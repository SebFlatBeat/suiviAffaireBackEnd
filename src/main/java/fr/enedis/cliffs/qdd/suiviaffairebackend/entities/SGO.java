package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class SGO {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull
    private String numeroAffaire;

    @NotNull
    private String etatAffaire;

    private String intervention;

    public SGO() {
    }

    public SGO(Long id, String numeroAffaire, String etatAffaire, String intervention) {
        Id = id;
        this.numeroAffaire = numeroAffaire;
        this.etatAffaire = etatAffaire;
        this.intervention = intervention;
    }

    public Long getId() {

        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

}
