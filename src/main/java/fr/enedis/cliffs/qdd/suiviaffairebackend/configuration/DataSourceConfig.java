package fr.enedis.cliffs.qdd.suiviaffairebackend.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder <?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.hibernate.dialect.PostgreSQLDialect");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/suiviAffaire");
        dataSourceBuilder.username("userSuiviAffaireApp");
        dataSourceBuilder.password("Sebda2812/1");
        return dataSourceBuilder.build();
    }
}
