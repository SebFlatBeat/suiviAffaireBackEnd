package fr.enedis.cliffs.qdd.suiviaffairebackend.dto;

import com.fasterxml.jackson.annotation.*;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;

@JsonPropertyOrder({"Id", "userApp", "sge", "blocageSource"})
public class BlocageResponse {

    @JsonProperty("Id")
    private Long Id;
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
        this.Id = blocage.getId();
        this.userApp = blocage.getUserApp();
        this.sge = blocage.getSge();
        this.blocageSource = blocage.getBlocageSource();
    }

    public BlocageResponse(Long Id, UserApp userApp, SGE sge, BlocageSource blocageSource) {
        this.Id = Id;
        this.userApp = userApp;
        this.sge = sge;
        this.blocageSource = blocageSource;
    }

    @JsonProperty("Id")
    public Long getId() {
        return Id;
    }

    @JsonProperty("Id")
    public void setId(Long Id) {
        this.Id = Id;
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
                "Id=" + Id +
                ", userApp=" + userApp +
                ", sge=" + sge +
                ", blocageSource=" + blocageSource +
                '}';
    }
}
