package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGEDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class SGEService {
    @Autowired
    SGEDao sgeDao;

    public void saveSGE(SGE sge) {
        sgeDao.save(sge);
    }

    public List<SGE> findAll() {
        return sgeDao.findAll();
    }

    public Page<SGE> findAllPageable(Pageable pageable) {
        return sgeDao.findAll(pageable);
    }

    public Page<SGE> filter(FilterForm filterForm, Pageable pageable) {
        return sgeDao.filter(filterForm.getNumeroAffaire(),
                filterForm.getPrm(),
                filterForm.getIdc(),
                filterForm.getPortefeuille(),
                filterForm.getPrestation(),
                filterForm.getContratDemande(),
                filterForm.getContratInitial(),
                filterForm.getEtatContractuel(),
                filterForm.getModeReleve(),
                filterForm.getNumeroDt(),
                filterForm.getStatutDt(),
                filterForm.getPrestationRealise(),
                filterForm.getRealisation(),
                filterForm.getEtatAffaire(),
                filterForm.getIntervention(),
                pageable
        );
    }
}
