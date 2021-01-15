package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class COSY {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String numeroAffaire;

    @NotNull
    private String etatAffaire;

    private String intervention;

    public COSY() {
    }

    public COSY(Long id, @NotNull String numeroAffaire, @NotNull String etatAffaire, String intervention) {
        this.id = id;
        this.numeroAffaire = numeroAffaire;
        this.etatAffaire = etatAffaire;
        this.intervention = intervention;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroAffaire() {
        return numeroAffaire;
    }

    public void setNumeroAffaire(String numeroAffaire) {
        this.numeroAffaire = numeroAffaire;
    }

    public String getEtatAffaire() {
        return etatAffaire;
    }

    public void setEtatAffaire(String etatAffaire) {
        this.etatAffaire = etatAffaire;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    @Override
    public String toString() {
        return "COSY{" +
                "id=" + id +
                ", numeroAffaire='" + numeroAffaire + '\'' +
                ", etatAffaire='" + etatAffaire + '\'' +
                ", intervention='" + intervention + '\'' +
                '}';
    }
}
