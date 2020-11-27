package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import fr.enedis.cliffs.qdd.suiviaffairebackend.security.BCryptEncoderConfig;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserApp {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull //Ajouter des contraintes de validations
    private String Nni;

    @NotNull //Rendre le mot de passe crypté
    private String password;

    @NotNull
    private String email;

    public UserApp() {
    }

    public UserApp(Long id, String nni, String password, String email) {
        Id = id;
        Nni = nni;
        this.password = BCryptEncoderConfig.passwordencoder().encode(password);
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNni() {
        return Nni;
    }

    public void setNni(String nni) {
        Nni = nni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCryptEncoderConfig.passwordencoder().encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
