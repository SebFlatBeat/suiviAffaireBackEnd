package fr.enedis.cliffs.qdd.suiviaffairebackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public DataSource getDataSource() {
        LOG.info("Build DataSourceConfig");
        DataSourceBuilder <?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.hibernate.dialect.PostgreSQLDialect");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/suiviAffaire");
        dataSourceBuilder.username("userSuiviAffaireApp");
        dataSourceBuilder.password("Sebda2812/1");
        LOG.info("DataSourceConfig OK");
        return dataSourceBuilder.build();
    }
}
