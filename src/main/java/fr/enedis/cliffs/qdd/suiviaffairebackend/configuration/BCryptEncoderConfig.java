package fr.enedis.cliffs.qdd.suiviaffairebackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BCryptEncoderConfig {

    private static final Logger LOG = LoggerFactory.getLogger(BCryptEncoderConfig.class);

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BCryptEncoderConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean(name = "passwordEncoder")
    public static PasswordEncoder passwordencoder(){
        LOG.trace("Encryption OK");
        return new BCryptPasswordEncoder();
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
