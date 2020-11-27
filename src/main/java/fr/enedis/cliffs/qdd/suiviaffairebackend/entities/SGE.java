package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class SGE {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull
    private String numeroAffaire;

    @NotNull
    private Long prm;

    @NotNull
    private Long idc;

    @NotNull
    private String portefeuille;

    @NotNull
    private String prestation;

    @NotNull
    private String contratDemande;

    @NotNull
    private String contratInitial;

    /**
     *Instantiate a new SGE
     */
    public SGE() {
    }

    /**
     *
     * @param id
     * @param numeroAffaire
     * @param prm
     * @param idc
     * @param portefeuille
     * @param prestation
     * @param contratDemande
     * @param contratInitial
     */
    public SGE(Long id, String numeroAffaire, Long prm, Long idc, String portefeuille,
               String prestation, String contratDemande, String contratInitial) {
        Id = id;
        this.numeroAffaire = numeroAffaire;
        this.prm = prm;
        this.idc = idc;
        this.portefeuille = portefeuille;
        this.prestation = prestation;
        this.contratDemande = contratDemande;
        this.contratInitial = contratInitial;
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

    public Long getPrm() {
        return prm;
    }

    public void setPrm(Long prm) {
        this.prm = prm;
    }

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public String getPortefeuille() {
        return portefeuille;
    }

    public void setPortefeuille(String portefeuille) {
        this.portefeuille = portefeuille;
    }

    public String getPrestation() {
        return prestation;
    }

    public void setPrestation(String prestation) {
        this.prestation = prestation;
    }

    public String getContratDemande() {
        return contratDemande;
    }

    public void setContratDemande(String contratDemande) {
        this.contratDemande = contratDemande;
    }

    public String getContratInitial() {
        return contratInitial;
    }

    public void setContratInitial(String contratInitial) {
        this.contratInitial = contratInitial;
    }
}
