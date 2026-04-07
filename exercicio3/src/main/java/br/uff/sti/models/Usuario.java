package br.uff.sti.models;

import jakarta.validation.constraints.NotNull;
import net.datafaker.Faker;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author leandroribeirodecicco
 */

@Table(name="usuario", schema = "ap3_exercicios")
public record Usuario(
        @Id Long id,
        @NotNull String username,
        @NotNull String nome,
        int idade,
        @NotNull String urlImagem
) {
    
    public static Usuario fake() {
        Faker faker = new Faker();
        return new Usuario(
            null,
            faker.credentials().username(),
            faker.name().fullName(),
            faker.number().numberBetween(18, 66),
            faker.internet().url()
        );
    }
    
    @Override
    public String toString(){
        return """
        =========================================================
        | Usuario       
        =========================================================
        | Id: %s
        | Username: %s
        | Name: %s
        | Idade: %s
        | UrlImage: %s
        =========================================================
        """.formatted(
                this.id,
                this.username,
                this.nome,
                this.idade,
                this.urlImagem
        );
    }
}

