package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.GECDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GECService {

    @Autowired
    GECDao gecDao;

    private static final Logger LOG = LoggerFactory.getLogger(GECService.class);

    public void saveGEC(GEC gec) {
        LOG.debug("Sauvegarde d'un gec");
        gecDao.save(gec);
    }

    public List<GEC> findAll() {
        LOG.debug("Renvoi une liste de tous les gec");
        return gecDao.findAll();
    }
}
