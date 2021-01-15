package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class SGE {

    @Id
    @GeneratedValue
    private Long id;

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

    @OneToOne
    @Cascade(CascadeType.DETACH)
    private COSY cosy;

    @OneToOne
    @Cascade(CascadeType.DETACH)
    private GEC gec;


    /**
     * Instantiate a new SGE
     */
    public SGE() {
    }

    /**
     * @param id
     * @param numeroAffaire
     * @param prm
     * @param idc
     * @param portefeuille
     * @param prestation
     * @param contratDemande
     * @param contratInitial
     * @param cosy
     * @param gec
     * @param blocage
     */
    public SGE(Long id, @NotNull String numeroAffaire, @NotNull Long prm, @NotNull Long idc, @NotNull String portefeuille, @NotNull String prestation, @NotNull String contratDemande, @NotNull String contratInitial, COSY cosy, GEC gec) {
        this.id = id;
        this.numeroAffaire = numeroAffaire;
        this.prm = prm;
        this.idc = idc;
        this.portefeuille = portefeuille;
        this.prestation = prestation;
        this.contratDemande = contratDemande;
        this.contratInitial = contratInitial;
        this.cosy = cosy;
        this.gec = gec;
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

    public COSY getCosy() {
        return cosy;
    }

    public void setCosy(COSY cosy) {
        this.cosy = cosy;
    }

    public GEC getGec() {
        return gec;
    }

    public void setGec(GEC gec) {
        this.gec = gec;
    }

    @Override
    public String toString() {
        return "SGE{" +
                "id=" + id +
                ", numeroAffaire='" + numeroAffaire + '\'' +
                ", prm=" + prm +
                ", idc=" + idc +
                ", portefeuille='" + portefeuille + '\'' +
                ", prestation='" + prestation + '\'' +
                ", contratDemande='" + contratDemande + '\'' +
                ", contratInitial='" + contratInitial + '\'' +
                ", cosy=" + cosy +
                ", gec=" + gec +
                '}';
    }
}
