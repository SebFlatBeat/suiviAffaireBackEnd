package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.COSYDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class COSYService {

    @Autowired
    COSYDao cosyDao;

    private static final Logger LOG = LoggerFactory.getLogger(COSYService.class);

    public void saveCOSY(COSY cosy) {
        LOG.debug("Sauvegarde cosy");
        cosyDao.save(cosy);
    }

    public List<COSY> findAll() {
        LOG.debug("Renvoi une liste de tous les cosy");
        return cosyDao.findAll();
    }
}
