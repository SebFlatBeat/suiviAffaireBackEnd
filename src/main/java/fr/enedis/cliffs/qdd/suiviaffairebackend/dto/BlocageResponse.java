package fr.enedis.cliffs.qdd.suiviaffairebackend.dto;

import com.fasterxml.jackson.annotation.*;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;

@JsonPropertyOrder({"id", "userApp", "sge", "blocageSource"})
public class BlocageResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("userApp")
    private UserApp userApp;
    @JsonProperty("sge")
    private SGE sge;
    @JsonProperty("blocageSource")
    private BlocageSource blocageSource;

    public BlocageResponse() {
        super();
    }

    public BlocageResponse(Blocage blocage){
        super();
        this.id = blocage.getId();
        this.userApp = blocage.getUserApp();
        this.sge = blocage.getSge();
        this.blocageSource = blocage.getBlocageSource();
    }

    public BlocageResponse(Long id, UserApp userApp, SGE sge, BlocageSource blocageSource) {
        this.id = id;
        this.userApp = userApp;
        this.sge = sge;
        this.blocageSource = blocageSource;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("userApp")
    public UserApp getUserApp() {
        return userApp;
    }

    @JsonProperty("userApp")
    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    @JsonProperty("sge")
    public SGE getSge() {
        return sge;
    }

    @JsonProperty("sge")
    public void setSge(SGE sge) {
        this.sge = sge;
    }

    @JsonProperty("blocageSource")
    public BlocageSource getBlocageSource() {
        return blocageSource;
    }

    @JsonProperty("blocageSource")
    public void setBlocageSource(BlocageSource blocageSource) {
        this.blocageSource = blocageSource;
    }

    @Override
    public String toString() {
        return "BlocageResponse{" +
                "id=" + id +
                ", userApp=" + userApp +
                ", sge=" + sge +
                ", blocageSource=" + blocageSource +
                '}';
    }
}
