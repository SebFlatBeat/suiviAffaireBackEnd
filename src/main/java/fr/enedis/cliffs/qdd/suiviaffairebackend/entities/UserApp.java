package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import fr.enedis.cliffs.qdd.suiviaffairebackend.configuration.BCryptEncoderConfig;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class UserApp {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Pattern(regexp = "^\\b[a-z[A-Z]][0-9]{5}?$")
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    public UserApp() {
    }

    public UserApp(Long id, @NotNull @Pattern(regexp = "^\\b[a-z[A-Z]][0-9]{5}?$") String username, @NotNull String password, @NotNull @Email String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "UserApp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
