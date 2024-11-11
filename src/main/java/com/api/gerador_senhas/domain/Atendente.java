package com.api.gerador_senhas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Atendente {

    @Id
    @Column(name = "ATENDENTE_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID atendente_id;

    private String nome;

    private String email;

    private String senha;
}
