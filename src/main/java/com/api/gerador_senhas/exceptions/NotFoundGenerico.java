package com.api.gerador_senhas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundGenerico extends RuntimeException{

    public NotFoundGenerico(String message) {
        super(message);
    }
}
