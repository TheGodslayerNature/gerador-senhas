package com.api.gerador_senhas.repository;

import com.api.gerador_senhas.domain.Senha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, UUID> {
}
