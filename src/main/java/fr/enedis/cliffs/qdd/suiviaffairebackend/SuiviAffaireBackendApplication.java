package fr.enedis.cliffs.qdd.suiviaffairebackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuiviAffaireBackendApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SuiviAffaireBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SuiviAffaireBackendApplication.class, args);
        LOG.info("Démarrage de l application");
    }

}
