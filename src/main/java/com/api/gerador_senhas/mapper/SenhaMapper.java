package com.api.gerador_senhas.mapper;

import com.api.gerador_senhas.domain.Senha;
import com.api.gerador_senhas.dtos.PostSenha;
import com.api.gerador_senhas.dtos.PutSenha;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SenhaMapper {
    Senha toSenha(PostSenha postSenha);
    Senha toSenha(PutSenha putSenha);
}
