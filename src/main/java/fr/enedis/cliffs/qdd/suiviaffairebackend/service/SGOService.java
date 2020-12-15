package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGODao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SGOService {

    @Autowired
    SGODao sgoDao;

    public void saveSGO(SGO sgo) {
        sgoDao.save(sgo);
    }

    public List<SGO> findAll() {
        return sgoDao.findAll();
    }
}
