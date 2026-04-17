package br.uff.exercicio4.modelo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table(name="post", schema = "ap4_exercicios")
@With
public record Post(
        @Id Long id,
        @NotNull(message="Não pode ficar em vazia.")
        LocalDateTime dataPostagem,
        @NotBlank(message="Não pode ficar em branco.")
        @Size(max=2000, message="O tamanho máximo da mensagem é 2000 carecteres.") 
        String mensagem,
        @NotNull(message="Deve haver um usuário associado.") 
        Long usuarioId,
        @Valid
        @MappedCollection(idColumn = "post_id", keyColumn = "ordem")
        List<Tag> tags
) {
}
