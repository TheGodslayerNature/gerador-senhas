package com.api.gerador_senhas.dtos.senhaDtos;

import com.api.gerador_senhas.domain.Atendimento;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutSenha {
    @NotEmpty(message = "Id não pode estar vazio")
    private UUID uuid;
    private int numero;
    private LocalDateTime dataGerada;
    private boolean status;
    private Atendimento atendimento;
}
