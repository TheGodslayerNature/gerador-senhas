package com.api.gerador_senhas.service;

import com.api.gerador_senhas.domain.Atendente;
import com.api.gerador_senhas.repository.AtendenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AtendenteService {

    private final AtendenteRepository repository;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public AtendenteService(AtendenteRepository repository) {
        this.repository = repository;
    }

    public List<Atendente> listAll() {
        return repository.findAll();
    }

    public Atendente getAtendente(UUID id) {
        return repository.findById(id).orElseThrow( () -> new RuntimeException("Não foi possivel encontrar o Atendente"));
    }

    public Atendente salvarAtendente(Atendente atendente) {
        if (!validarEmail(atendente.getEmail())){
            throw new RuntimeException("Email não é valido");
        }
        return repository.save(atendente);
    }

    public void delete(UUID id) {
        getAtendente(id);
        repository.delete(getAtendente(id));
    }

    public Atendente editAtentende(Atendente atendente) {
        return Atendente.builder()
                .atendente_id(atendente.getAtendente_id())
                .nome(atendente.getNome())
                .email(atendente.getEmail())
                .senha(atendente.getSenha())
                .atendimentos(atendente.getAtendimentos()).build();
    }


    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
