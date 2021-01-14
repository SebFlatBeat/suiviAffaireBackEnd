package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
public class Blocage {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @Null
    private UserApp userApp;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private SGE sge;


    @Enumerated(EnumType.STRING)
    private BlocageSource blocageSource;

    public Blocage() {
    }

    public Blocage(Long id, @Null UserApp userApp, SGE sge, BlocageSource blocageSource) {
        Id = id;
        this.userApp = userApp;
        this.sge = sge;
        this.blocageSource = blocageSource;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public SGE getSge() {
        return sge;
    }

    public void setSge(SGE sge) {
        this.sge = sge;
    }

    public BlocageSource getBlocageSource() {
        return blocageSource;
    }

    public void setBlocageSource(BlocageSource blocageSource) {
        this.blocageSource = blocageSource;
    }

    @Override
    public String toString() {
        return "Blocage{" +
                "Id=" + Id +
                ", userApp=" + userApp +
                ", sge=" + sge +
                ", blocageSource=" + blocageSource +
                '}';
    }
}
