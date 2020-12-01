package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGEDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SGEService {
    @Autowired
    SGEDao sgeDao;

    public void saveSGE(SGE sge){
        sgeDao.save(sge);
    }

    public List<SGE> findAll() { return sgeDao.findAll(); }
}
