package fr.enedis.cliffs.qdd.suiviaffairebackend.beans;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;

import java.util.List;

public class AllDataListBean {
    private List <SGE> sge;
    private List <SGO> sgo;
    private List <GEC> gec;

    public List<SGE> getSge() {
        return sge;
    }

    public void setSge(List<SGE> sge) {
        this.sge = sge;
    }

    public List<SGO> getSgo() {
        return sgo;
    }

    public void setSgo(List<SGO> sgo) {
        this.sgo = sgo;
    }

    public List<GEC> getGec() {
        return gec;
    }

    public void setGec(List<GEC> gec) {
        this.gec = gec;
    }
}
