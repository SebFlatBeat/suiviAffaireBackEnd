package fr.enedis.cliffs.qdd.suiviaffairebackend.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Blocage {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private UserApp userApp;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private SGE sge;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private SGO sgo;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private GEC gec;

    @Enumerated(EnumType.STRING)
    private BlocageSource blocageSource;

    public Blocage() {
    }

    public Blocage(Long id, UserApp userApp, SGE sge, SGO sgo, GEC gec, BlocageSource blocageSource) {
        Id = id;
        this.userApp = userApp;
        this.sge = sge;
        this.sgo = sgo;
        this.gec = gec;
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

    public SGO getSgo() {
        return sgo;
    }

    public void setSgo(SGO sgo) {
        this.sgo = sgo;
    }

    public GEC getGec() {
        return gec;
    }

    public void setGec(GEC gec) {
        this.gec = gec;
    }

    public BlocageSource getBlocageSource() {
        return blocageSource;
    }

    public void setBlocageSource(BlocageSource blocageSource) {
        this.blocageSource = blocageSource;
    }
}
