package fr.enedis.cliffs.qdd.suiviaffairebackend.dto;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;

import java.util.List;

public class AllDataListDto  {
    private List <SGE> sge;
    private List <COSY> cosy;
    private List <GEC> gec;

    public List<SGE> getSge() {
        return sge;
    }

    public void setSge(List<SGE> sge) {
        this.sge = sge;
    }

    public List<COSY> getCosy() {
        return cosy;
    }

    public void setCosy(List<COSY> cosy) {
        this.cosy = cosy;
    }

    public List<GEC> getGec() {
        return gec;
    }

    public void setGec(List<GEC> gec) {
        this.gec = gec;
    }
}
