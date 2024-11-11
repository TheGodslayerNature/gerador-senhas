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
public class Guinche {

    @Id
    @Column(name = "GUINCHE_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID guincheId;

    private int numero;
}
