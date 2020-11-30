package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGODao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import org.springframework.beans.factory.annotation.Autowired;

public class SGOService {

    @Autowired
    SGODao sgoDao;

    public void saveSGO(SGO sgo){
        sgoDao.save(sgo);
    }
}
