package br.uff.sti.models;

import org.springframework.data.relational.core.mapping.Table;
import java.util.List;
import java.util.stream.Stream;
import net.datafaker.Faker;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author leandroribeirodecicco
 *
**/

@Table(name="post_tag", schema = "ap3_exercicios")
public record Tag(
        String nome
) {
    public static List<Tag> of(String... strs) {
        return Stream.of(strs)
                .map(Tag::new)
                .toList();
    }

    public static List<String> stringOf(List<Tag> tags) {
        return tags.stream()
                .map(Tag::nome)   // extract the attribute
                .collect(Collectors.toList()); // convert to List<String>
    }
    
    public static List<Tag> fakeOf(int quantidade) {
        Faker faker = new Faker();    
        List<String> lotrTags = Arrays.asList("rpg", "fps");
        Set<Tag> randomTags = Stream.generate(() -> faker.options().nextElement(lotrTags))
                                        .map(Tag::new)
                                        .limit(quantidade)
                                        .collect(Collectors.toSet());
        return randomTags.stream().collect(Collectors.toList());        
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}

