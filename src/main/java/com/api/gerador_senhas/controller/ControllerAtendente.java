package com.api.gerador_senhas.controller;

import com.api.gerador_senhas.domain.Atendente;
import com.api.gerador_senhas.service.AtendenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/atendente")
public class ControllerAtendente {

    private final AtendenteService service;

    public ControllerAtendente(AtendenteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Atendente>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendente> getAtendente(@PathVariable UUID id){
        return ResponseEntity.ok(service.getAtendente(id));
    }

    @PostMapping("")
    public ResponseEntity<Atendente> salvarAtendente(@RequestBody Atendente atendente){
        return ResponseEntity.ok(service.salvarAtendente(atendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendente(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("")
    public ResponseEntity<Atendente> editAtendente(@RequestBody Atendente atendente){
        return ResponseEntity.ok(service.editAtentende(atendente));
    }
}
