package com.api.gerador_senhas.controller;

import com.api.gerador_senhas.domain.Atendimento;
import com.api.gerador_senhas.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/atendimento")
public class ControllerAtendimento {

    private final AtendimentoService service;

    public ControllerAtendimento(AtendimentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Atendimento>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getAtendimento(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getAtendimento(id));
    }

    @PostMapping
    public ResponseEntity<Atendimento> salvarAtendimento(@RequestBody Atendimento atendimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarAtendimento(atendimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtendimento(@PathVariable UUID id){
        service.deletarAtendimento(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Atendimento> editAtendimento(@RequestBody Atendimento atendimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.editarAtendimento(atendimento));
    }
}
