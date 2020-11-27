package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class GEC {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull
    private Long idc;

    @NotNull
    private String etatContractuel;

    private String modeReleve;

    private Long numeroDt;

    private String statutDt;

    private String prestationRealise;

    private String realisation;

    @OneToOne
    @Cascade(CascadeType.DETACH)
    private SGE sge;

    public GEC() {
    }

    public GEC(Long id, Long idc, String etatContractuel, String modeReleve, Long numeroDt, String statutDt,
               String prestationRealise, String realisation, SGE sge) {
        Id = id;
        this.idc = idc;
        this.etatContractuel = etatContractuel;
        this.modeReleve = modeReleve;
        this.numeroDt = numeroDt;
        this.statutDt = statutDt;
        this.prestationRealise = prestationRealise;
        this.realisation = realisation;
        this.sge = sge;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
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

    public SGE getSge() {
        return sge;
    }

    public void setSge(SGE sge) {
        this.sge = sge;
    }
}
