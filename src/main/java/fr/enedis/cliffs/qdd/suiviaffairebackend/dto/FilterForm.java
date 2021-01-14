package fr.enedis.cliffs.qdd.suiviaffairebackend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FilterForm {

    @JsonProperty("numeroAffaire")
    private String numeroAffaire;
    @JsonProperty("prm")
    private Long prm;
    @JsonProperty("idc")
    private Long idc;
    @JsonProperty("portefeuille")
    private String portefeuille;
    @JsonProperty("etatContractuel")
    private String etatContractuel;
    @JsonProperty("etatAffaire")
    private String etatAffaire;
    @JsonProperty("blocageSource")
    private String blocageSource;

    public FilterForm() {
    }

    public FilterForm(String numeroAffaire, String prm, String idc,
                      String portefeuille, String etatContractuel,
                      String etatAffaire, String blocageSource) {
        this.numeroAffaire = numeroAffaire;
        this.prm = Long.parseLong(prm);
        this.idc = Long.parseLong(idc);
        this.portefeuille = portefeuille;
        this.etatContractuel = etatContractuel;
        this.etatAffaire = etatAffaire;
        this.blocageSource = blocageSource;
    }

    public String getNumeroAffaire() {
        if (!numeroAffaire.isEmpty()) {
            return numeroAffaire;
        } else {
            return null;
        }
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
        if (!portefeuille.isEmpty()) {
            return portefeuille;
        } else {
            return null;
        }
    }

    public void setPortefeuille(String portefeuille) {
        this.portefeuille = portefeuille;
    }

    public String getEtatContractuel() {
        if (!etatContractuel.isEmpty()) {
            return etatContractuel;
        }
        return null;
    }

    public void setEtatContractuel(String etatContractuel) {
        this.etatContractuel = etatContractuel;
    }

    public String getEtatAffaire() {
        if (!etatAffaire.isEmpty()) {
            return etatAffaire;
        } else {
            return null;
        }
    }

    public void setEtatAffaire(String etatAffaire) {
        this.etatAffaire = etatAffaire;
    }

    public BlocageSource getBlocageSource() {
        if (!blocageSource.isEmpty()) {
            return BlocageSource.valueOf(blocageSource);
        } else {
            return null;
        }

    }

    public void setBlocageSource(String blocageSource) {
        this.blocageSource = blocageSource;
    }

    @Override
    public String toString() {
        return "FilterForm{" +
                "numeroAffaire='" + numeroAffaire + '\'' +
                ", prm=" + prm +
                ", idc=" + idc +
                ", portefeuille='" + portefeuille + '\'' +
                ", etatContractuel='" + etatContractuel + '\'' +
                ", etatAffaire='" + etatAffaire + '\'' +
                ", blocageSource='" + blocageSource + '\'' +
                '}';
    }
}
