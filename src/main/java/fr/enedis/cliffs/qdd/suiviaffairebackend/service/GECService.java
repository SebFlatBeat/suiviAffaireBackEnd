package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.GECDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GECService {

    @Autowired
    GECDao gecDao;

    public void saveGEC(GEC gec) {
        gecDao.save(gec);
    }

    public List<GEC> findAll() {
        return gecDao.findAll();
    }
}
