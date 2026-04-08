package br.uff.sti;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.RelationalManagedTypes;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author leandroribeirodecicco
 */

@Configuration
@EnableJdbcRepositories("br.uff.sti.repositories")
public class JdbcConfiguration extends AbstractJdbcConfiguration {

    /**
     * Aqui faz um ajuste fino no JdbcData
     * @param namingStrategy
     * @param customConversions
     * @param jdbcManagedTypes
     * @return
     */
    @Override
    public JdbcMappingContext jdbcMappingContext(Optional<NamingStrategy> namingStrategy,
                                                 JdbcCustomConversions customConversions,
                                                 RelationalManagedTypes jdbcManagedTypes) {
        JdbcMappingContext mapping= super.jdbcMappingContext(namingStrategy, customConversions, jdbcManagedTypes);
        mapping.setForceQuote(false);
        mapping.setSingleQueryLoadingEnabled(true);
        return mapping;
    }

    /**
     * Aqui cria conversores de tipo
     * @return
     */
    @Override
    protected List<?> userConverters() {
        return List.of(/*Adicione os novos conversores aqui */);
    }
}
