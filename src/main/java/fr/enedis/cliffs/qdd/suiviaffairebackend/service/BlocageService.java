package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.BlocageDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.utils.PercentageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlocageService {

    @Autowired
    BlocageDao blocageDao;

    @Autowired
    UserAppService userAppService;

    @Autowired
    PercentageCalculator percentageCalculator;

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

    public void updateBlocage(Long id, String choix, String username) {
        Optional<Blocage> blocage = findById(id);
        Optional<UserApp> user = userAppService.findByUsername(username);
        if (blocage.isPresent()) {
            switch (choix) {
                case "SGE":
                    blocage.get().setBlocageSource(BlocageSource.SGE);
                    break;
                case "SGO":
                    blocage.get().setBlocageSource(BlocageSource.SGO);
                    break;
                case "GEC":
                    blocage.get().setBlocageSource(BlocageSource.GEC);
                    break;
                default:
                    blocage.get().setBlocageSource(BlocageSource.NONTRAITE);
                    break;
            }
            user.ifPresent(app -> blocage.get().setUserApp(app));
            blocageDao.save(blocage.get());
        }
    }

    public Page<Blocage> filter(FilterForm filterForm, Pageable pageable) {
        return blocageDao.findByfilter(filterForm.getNumeroAffaire(),
                filterForm.getPrm(),
                filterForm.getIdc(),
                filterForm.getPortefeuille(),
                filterForm.getEtatContractuel(),
                filterForm.getEtatAffaire(),
                filterForm.getBlocageSource(),
                pageable
        );
    }

    public Page<Blocage> filter2(FilterForm filterForm, Pageable pageable) {
        return blocageDao.findByfilter2(
                filterForm.getBlocageSource(),
                pageable
        );
    }

    public int[] percent() {
        List<Blocage> blocageList = blocageDao.findAll();
        int nonTraite = 0;
        int sge = 0;
        int sgo = 0;
        int gec = 0;
        int total = 0;
        for (Blocage b : blocageList) {
            switch (b.getBlocageSource()) {
                case NONTRAITE:
                    nonTraite++;
                    total++;
                    break;
                case SGE:
                    sge++;
                    total++;
                    break;
                case SGO:
                    sgo++;
                    total++;
                    break;
                case GEC:
                    gec++;
                    total++;
                    break;
            }
        }
        int percentageNonTraite = percentageCalculator.caculPercentage(nonTraite, total);
        int percentageSge = percentageCalculator.caculPercentage(sge, total);
        int percentageSgo = percentageCalculator.caculPercentage(sgo, total);
        int percentageGec = percentageCalculator.caculPercentage(gec, total);

        return new int[]{percentageNonTraite, percentageSge, percentageSgo, percentageGec};
    }
}
