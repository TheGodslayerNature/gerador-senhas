package com.api.gerador_senhas.controller;

import com.api.gerador_senhas.domain.Senha;
import com.api.gerador_senhas.dtos.PutSenha;
import com.api.gerador_senhas.service.SenhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gerador")
public class ControllerSenha {

    private final SenhaService service;

    public ControllerSenha(SenhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Senha>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Senha> getSenha(@PathVariable UUID id){
        return ResponseEntity.ok(service.getSenha(id));
    }

    @PostMapping("/gerar")
    public ResponseEntity<Senha> gerarSenha(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gerarSenha());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSenha(@PathVariable UUID id){
        service.deleteSenha(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Senha> editSenha(@RequestBody PutSenha putSenha){
        return ResponseEntity.ok(service.editSenha(putSenha));
    }
}
