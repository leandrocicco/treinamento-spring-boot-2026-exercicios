package br.uff.exercicio4.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="usuario", schema = "ap4_exercicios")
public record Usuario(
        @Id Long id,
        @NotBlank(message="Não pode ficar em branco.")
        String username,
        @NotBlank(message="Não pode ficar em branco.")
        String nome,
        @Positive(message="Deve ser um valor positivo.") 
        int idade,
        @NotBlank(message="Não pode ficar em branco.") 
        String urlImagem
) {

}
