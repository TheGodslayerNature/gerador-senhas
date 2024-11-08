package com.api.gerador_senhas.service;

import com.api.gerador_senhas.domain.Senha;
import com.api.gerador_senhas.dtos.PostSenha;
import com.api.gerador_senhas.dtos.PutSenha;
import com.api.gerador_senhas.mapper.SenhaMapper;
import com.api.gerador_senhas.repository.SenhaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SenhaService {

    private final SenhaRepository repository;
    private final SenhaMapper senhaMapper;

    private int maxNumero = 5;
    private int actualNumero = 0;
    private int minNumero = 0;

    public SenhaService(SenhaRepository repository, SenhaMapper senhaMapper) {
        this.repository = repository;
        this.senhaMapper = senhaMapper;
    }

    public List<Senha> listAll() {
        return repository.findAll();
    }

    public Senha getSenha(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Senha não encontrada"));
    }

    public Senha gerarSenha() {
        PostSenha postSenha = PostSenha.builder()
                .numero(criarNumero())
                .dataGerada(LocalDateTime.now())
                .status(true).build();
        return repository.save(senhaMapper.toSenha(postSenha));
    }

    public void deleteSenha(UUID id){
        repository.delete(getSenha(id));
    }

    public Senha editSenha(PutSenha putSenha) {
        getSenha(putSenha.getUuid());
        Senha senha = senhaMapper.toSenha(putSenha);
        senha.setUuid(putSenha.getUuid());
        return repository.save(senha);
    }

    private int criarNumero(){
        if (actualNumero == maxNumero){
            actualNumero = 1;
            return actualNumero;
        } else if (actualNumero >= minNumero) {
            actualNumero++;
            return actualNumero;
        }
        return 1;
    }
}
