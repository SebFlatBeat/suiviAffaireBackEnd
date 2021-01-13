package fr.enedis.cliffs.qdd.suiviaffairebackend.dto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FilterForm {

    private String numeroAffaire;
    private Long prm;
    private Long idc;
    private String portefeuille;
    private String prestation;
    private String contratDemande;
    private String contratInitial;
    private String etatContractuel;
    private String modeReleve;
    private Long numeroDt;
    private String statutDt;
    private String prestationRealise;
    private String realisation;
    private String etatAffaire;
    private String intervention;
    private String blocageSource;

    public FilterForm() {
    }

    public FilterForm(String numeroAffaire, Long prm, Long idc, String portefeuille, String prestation,
                      String contratDemande, String contratInitial, String etatContractuel,
                      String modeReleve, Long numeroDt, String statutDt, String prestationRealise,
                      String realisation, String etatAffaire, String intervention, String blocageSource) {
        this.numeroAffaire = numeroAffaire;
        this.prm = prm;
        this.idc = idc;
        this.portefeuille = portefeuille;
        this.prestation = prestation;
        this.contratDemande = contratDemande;
        this.contratInitial = contratInitial;
        this.etatContractuel = etatContractuel;
        this.modeReleve = modeReleve;
        this.numeroDt = numeroDt;
        this.statutDt = statutDt;
        this.prestationRealise = prestationRealise;
        this.realisation = realisation;
        this.etatAffaire = etatAffaire;
        this.intervention = intervention;
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

    public String getEtatContractuel() {
        return etatContractuel;
    }

    public void setEtatContractuel(String etatContractuel) {
        this.etatContractuel = etatContractuel;
    }

    public String getModeReleve() {
        return modeReleve;
    }

    public void setModeReleve(String modeReleve) {
        this.modeReleve = modeReleve;
    }

    public Long getNumeroDt() {
        return numeroDt;
    }

    public void setNumeroDt(Long numeroDt) {
        this.numeroDt = numeroDt;
    }

    public String getStatutDt() {
        return statutDt;
    }

    public void setStatutDt(String statutDt) {
        this.statutDt = statutDt;
    }

    public String getPrestationRealise() {
        return prestationRealise;
    }

    public void setPrestationRealise(String prestationRealise) {
        this.prestationRealise = prestationRealise;
    }

    public String getRealisation() {
        return realisation;
    }

    public void setRealisation(String realisation) {
        this.realisation = realisation;
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

    public String getBlocageSource() {
        return blocageSource;
    }

    public void setBlocageSource(String blocageSource) {
        this.blocageSource = blocageSource;
    }
}
