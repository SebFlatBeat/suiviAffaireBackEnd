package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.BlocageDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.utils.PercentageCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(BlocageService.class);

    public void saveBlocage(Blocage blocage) {
        LOG.debug("Sauvegarde du blocage");
        blocageDao.save(blocage);
    }

    public Page<Blocage> findAllPageable(Pageable pageable) {
        LOG.debug("Recherche de tous les blocages");
        return blocageDao.findAll(pageable);
    }

    public Optional<Blocage> findById(Long id) {
        LOG.debug("Recherche d'un blocage par id");
        return blocageDao.findById(id);
    }

    public void updateBlocage(Long id, String choix, String username) {
        LOG.debug("Mise à jour d'un blocage");
        Optional<Blocage> blocage = findById(id);
        Optional<UserApp> user = userAppService.findByUsername(username);
        LOG.trace("Set de la source du blocage");
        if (blocage.isPresent()) {
            switch (choix) {
                case "SGE":
                    blocage.get().setBlocageSource(BlocageSource.SGE);
                    break;
                case "COSY":
                    blocage.get().setBlocageSource(BlocageSource.COSY);
                    break;
                case "GEC":
                    blocage.get().setBlocageSource(BlocageSource.GEC);
                    break;
                default:
                    blocage.get().setBlocageSource(BlocageSource.NONTRAITE);
                    break;
            }
            LOG.trace("Set de l'utilisateur");
            user.ifPresent(app -> blocage.get().setUserApp(app));
            LOG.trace("Sauvegarde du blocage");
            blocageDao.save(blocage.get());
            LOG.trace("Blocage sauvegardé");
        }
        LOG.info("Blocage mis à jour");
    }

    public Page<Blocage> filter(FilterForm filterForm, Pageable pageable) {
        LOG.debug("Recherche des blocages avec les filtres");
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

    public int[] percent() {
        LOG.debug("Création du pourcentage");
        List<Blocage> blocageList = blocageDao.findAll();
        int nonTraite = 0;
        int sge = 0;
        int cosy = 0;
        int gec = 0;
        int total = 0;
        LOG.trace("Boucle pour faire la répartition");
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
                case COSY:
                    cosy++;
                    total++;
                    break;
                case GEC:
                    gec++;
                    total++;
                    break;
            }
        }
        LOG.trace("Calcul de chaque pourcentage");
        int percentageNonTraite = percentageCalculator.caculPercentage(nonTraite, total);
        int percentageSge = percentageCalculator.caculPercentage(sge, total);
        int percentageCosy = percentageCalculator.caculPercentage(cosy, total);
        int percentageGec = percentageCalculator.caculPercentage(gec, total);
        LOG.info("Renvoi sous un tableau l'ensemble des résultats");
        return new int[]{percentageNonTraite, percentageSge, percentageCosy, percentageGec};
    }
}
