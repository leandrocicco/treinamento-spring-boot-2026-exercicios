package br.uff.exercicio4.modelo;

import lombok.experimental.Delegate;
import jakarta.validation.Valid;

public record PostComUsuario(
            @Valid @Delegate Post post,
            Usuario usuario
    ){

    }

