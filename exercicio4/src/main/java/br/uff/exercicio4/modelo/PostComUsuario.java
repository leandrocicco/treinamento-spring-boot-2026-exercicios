package br.uff.exercicio4.modelo;

import lombok.experimental.Delegate;

public record PostComUsuario(
            @Delegate Post post,
            Usuario usuario
    ){

    }

