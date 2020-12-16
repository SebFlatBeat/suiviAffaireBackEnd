package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.BlocageDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlocageService {

    @Autowired
    BlocageDao blocageDao;

    @Autowired
    UserAppService userAppService;

    public Page<Blocage> findAll(Pageable pageable) {
        return blocageDao.findAll(pageable);
    }

    public void saveBlocage(Blocage blocage) {
        blocageDao.save(blocage);
    }

    public Page<Blocage> findAllPageable(Pageable pageable) {
        return blocageDao.findAll(pageable);
    }

    public Optional<Blocage> findById(Long id) {
        return blocageDao.findById(id);
    }

    public void updateBlocage(Long id, Long userId, String choix) {
        Optional<Blocage> blocage = findById(id);
        Optional<UserApp> userApp = userAppService.findById(userId);
        if (blocage.isPresent()) {
            blocage.get().setUserApp(userApp.get());
            if (choix.equals("SGE")) {
                blocage.get().setBlocageSource(BlocageSource.SGE);
            }
            if (choix.equals("SGO")) {
                blocage.get().setBlocageSource(BlocageSource.SGO);
            }
            if (choix.equals("GEC")) {
                blocage.get().setBlocageSource(BlocageSource.GEC);
            }
            if (choix.equals("nonTraite")) {
                blocage.get().setBlocageSource(BlocageSource.nonTraite);
            }
            blocageDao.save(blocage.get());
        }
    }
}
