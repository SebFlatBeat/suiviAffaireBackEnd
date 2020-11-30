package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.GECDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import org.springframework.beans.factory.annotation.Autowired;

public class GECService {
    @Autowired
    GECDao gecDao;

    public void saveGEC(GEC gec){
        gecDao.save(gec);
    }
}
