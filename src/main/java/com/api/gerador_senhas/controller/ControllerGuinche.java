package com.api.gerador_senhas.controller;

import com.api.gerador_senhas.domain.Guinche;
import com.api.gerador_senhas.service.GuincheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/guinche")
public class ControllerGuinche {

    private final GuincheService service;

    public ControllerGuinche(GuincheService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Guinche>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guinche> getGuinche(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getGuinche(id));
    }

    @PostMapping("")
    public ResponseEntity<Guinche> salvarGuinche(@RequestBody Guinche guinche) {
        return ResponseEntity.ok(service.salvarGuinche(guinche));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuinche(@PathVariable UUID id) {
        service.deleteGuinche(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Guinche> editGuinche(@RequestBody Guinche guinche) {
        return ResponseEntity.ok(service.editGuinche(guinche));
    }
}
