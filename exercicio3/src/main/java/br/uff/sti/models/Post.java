package br.uff.sti.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import net.datafaker.Faker;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import java.util.Random;

/**
 *
 * @author leandroribeirodecicco
 */

@Table(name="post", schema = "ap3_exercicios")
@With
public record Post(
        @Id Long id,
        @NotNull LocalDateTime dataPostagem,
        @Size(max=2000) String mensagem,
        @NotNull @Column("usuario_id") AggregateReference<Usuario, Long>  usuario,
        @MappedCollection(idColumn = "post_id", keyColumn = "ordem")
        List<Tag> tags
) {
    
    public static Post fake(Usuario usuario) {
        Faker faker = new Faker();    
        Instant randomInst = faker.timeAndDate().between(Instant.now().minus(15,ChronoUnit.DAYS), Instant.now());
        LocalDateTime randomLDT = LocalDateTime.ofInstant(randomInst, ZoneId.systemDefault());
        List<String> words = faker.lorem().words(60);
        if (new Random().nextInt(10) % 2 == 0) words.add("ORC");  else words.add("GOBLIN");
        Collections.shuffle(words);
        return new Post(
                null,
                randomLDT,
                String.join(" ", words),
                AggregateReference.to(usuario.id()),
                Tag.fakeOf(1)
        );
    }
    
    @Override
    public String toString(){
        return """
        =========================================================
        | Post
        =========================================================       
        | Id: %s
        | DataPostagem: %s
        | Mensagem: %s
        | UsuarioId: %s
        | Tags: %s
        =========================================================
        """.formatted(
                this.id,
                this.dataPostagem,
                this.mensagem,
                this.usuario.getId(),                
                String.join(", ", Tag.stringOf(this.tags))
        );
    }
}

