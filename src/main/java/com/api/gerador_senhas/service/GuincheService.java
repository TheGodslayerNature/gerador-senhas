package com.api.gerador_senhas.service;

import com.api.gerador_senhas.domain.Guinche;
import com.api.gerador_senhas.repository.GuincheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GuincheService {
    private final GuincheRepository repository;

    public GuincheService(GuincheRepository repository) {
        this.repository = repository;
    }

    public List<Guinche> listAll() {
        return repository.findAll();
    }

    public Guinche getGuinche(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o Guinche"));
    }

    public Guinche salvarGuinche(Guinche guinche) {
        return repository.save(guinche);
    }

    public void deleteGuinche(UUID id) {
        getGuinche(id);
        repository.delete(getGuinche(id));
    }

    public Guinche editGuinche(Guinche guinche) {
        return Guinche.builder().guincheId(guinche.getGuincheId())
                .numero(guinche.getNumero()).build();
    }
}
