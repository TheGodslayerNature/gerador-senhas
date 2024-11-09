package com.api.gerador_senhas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ATENDIMENTO_ID")
    private UUID atendimentoId;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    private String observacao;

    @OneToOne
    @JoinColumn(name = "SENHA_ID")
    private Senha senha;
}
