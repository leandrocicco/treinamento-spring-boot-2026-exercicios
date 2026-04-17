package br.uff.exercicio4.modelo;

import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Stream;

@Table(name="post_tag", schema = "ap4_exercicios")
public record Tag(
        @NotBlank(message="Não pode ficar em branco.")
        String nome
) {
    public static List<Tag> of(String... strs) {
        return Stream.of(strs)
                .map(Tag::new)
                .toList();
            }
}
