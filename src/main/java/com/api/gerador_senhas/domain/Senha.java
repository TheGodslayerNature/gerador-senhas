package com.api.gerador_senhas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Senha {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "SENHA_ID")
    private UUID uuid;

    private int numero;

    @Column(name = "DATA_GERADA")
    private LocalDateTime dataGerada;

    private boolean status;

    @OneToOne(mappedBy = "senha")
    private Atendimento atendimento;
}
