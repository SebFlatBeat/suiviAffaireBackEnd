package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGEDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class SGEService {
    @Autowired
    SGEDao sgeDao;

    private static final Logger LOG = LoggerFactory.getLogger(SGEService.class);

    public void saveSGE(SGE sge) {
        LOG.debug("Sauvegarde sge");
        sgeDao.save(sge);
    }

    public List<SGE> findAll() {
        LOG.debug("Renvoi une liste de tous les sge");
        return sgeDao.findAll();
    }

    public Page<SGE> findAllPageable(Pageable pageable) {
        LOG.debug("Renvoi une page paginée de tous les sge");
        return sgeDao.findAll(pageable);
    }

}
