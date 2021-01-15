package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.COSYDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class COSYService {

    @Autowired
    COSYDao cosyDao;

    public void saveCOSY(COSY cosy) {
        cosyDao.save(cosy);
    }

    public List<COSY> findAll() {
        return cosyDao.findAll();
    }
}
