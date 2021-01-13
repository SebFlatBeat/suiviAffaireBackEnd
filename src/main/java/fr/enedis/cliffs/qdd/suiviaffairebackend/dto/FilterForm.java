package fr.enedis.cliffs.qdd.suiviaffairebackend.dto;


import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FilterForm {

    private String numeroAffaire;
    private Long prm;
    private Long idc;
    private String portefeuille;
    private String etatContractuel;
    private String etatAffaire;
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

    public String getEtatContractuel() {
        return etatContractuel;
    }

    public void setEtatContractuel(String etatContractuel) {
        this.etatContractuel = etatContractuel;
    }

    public String getEtatAffaire() {
        return etatAffaire;
    }

    public void setEtatAffaire(String etatAffaire) {
        this.etatAffaire = etatAffaire;
    }

    public Enum getBlocageSource() {
        return BlocageSource.valueOf(blocageSource);
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
