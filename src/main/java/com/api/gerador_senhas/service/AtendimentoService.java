package com.api.gerador_senhas.service;

import com.api.gerador_senhas.domain.Atendimento;
import com.api.gerador_senhas.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AtendimentoService {

    private final AtendimentoRepository repository;

    public AtendimentoService(AtendimentoRepository repository) {
        this.repository = repository;
    }

    public List<Atendimento> listAll() {
        return repository.findAll();
    }

    public Atendimento getAtendimento(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o atendimento"));
    }

    public Atendimento salvarAtendimento(Atendimento atendimento){
        Atendimento atendimentoToSave = Atendimento.builder()
                .inicio(LocalDateTime.now())
                .fim(null)
                .observacao(atendimento.getObservacao())
                .atendente(atendimento.getAtendente()).build();

        return repository.save(atendimentoToSave);
    }

    public void deletarAtendimento(UUID id) {
        repository.delete(getAtendimento(id));
    }

    public Atendimento editarAtendimento(Atendimento atendimento) {
        getAtendimento(atendimento.getAtendimentoId());
        Atendimento atendimentoToSave = Atendimento.builder()
                .atendimentoId(atendimento.getAtendimentoId())
                .inicio(atendimento.getInicio())
                .fim(atendimento.getFim())
                .observacao(atendimento.getObservacao())
                .atendente(atendimento.getAtendente()).build();
        return repository.save(atendimentoToSave);
    }
}
