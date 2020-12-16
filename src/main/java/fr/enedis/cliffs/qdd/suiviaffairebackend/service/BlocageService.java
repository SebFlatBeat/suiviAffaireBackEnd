package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.BlocageDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlocageService {

    @Autowired
    BlocageDao blocageDao;

    public Page<Blocage> findById(Pageable pageable, Long id) {
        return blocageDao.findByIdPageable(id,pageable);
    }

    public void saveBlocage(Blocage blocage){
        blocageDao.save(blocage);
    }
}
