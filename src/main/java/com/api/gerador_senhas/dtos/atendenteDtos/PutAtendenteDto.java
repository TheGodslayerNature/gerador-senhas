package com.api.gerador_senhas.dtos.atendenteDtos;

import com.api.gerador_senhas.domain.Atendimento;
import com.api.gerador_senhas.domain.Guinche;
import lombok.*;

import java.util.List;
import java.util.UUID;

public record PutAtendenteDto(@NonNull UUID id,
                              String nome,
                              String email,
                              String senha,
                              List<Atendimento> atendimentos,
                              Guinche guinche) {
}
