package com.api.gerador_senhas.repository;

import com.api.gerador_senhas.domain.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, UUID> {
}
