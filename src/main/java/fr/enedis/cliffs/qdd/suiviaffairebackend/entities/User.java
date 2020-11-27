package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull //Ajouter des contraintes de validations
    private String Nni;

    @NotNull //Rendre le mot de passe crypté
    private String password;

    @NotNull
    private String email;

    public User() {
    }

    public User(Long id, String nni, String password, String email) {
        Id = id;
        Nni = nni;
        this.password = password;
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
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
