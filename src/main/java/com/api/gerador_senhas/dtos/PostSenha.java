package com.api.gerador_senhas.dtos;

import com.api.gerador_senhas.domain.Atendimento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostSenha {
    private int numero;
    private LocalDateTime dataGerada;
    private boolean status;
    private Atendimento atendimento;
}
