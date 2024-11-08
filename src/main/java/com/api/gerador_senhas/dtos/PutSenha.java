package com.api.gerador_senhas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutSenha {
    private UUID uuid;
    private int numero;
    private LocalDateTime dataGerada;
    private boolean status;
}
