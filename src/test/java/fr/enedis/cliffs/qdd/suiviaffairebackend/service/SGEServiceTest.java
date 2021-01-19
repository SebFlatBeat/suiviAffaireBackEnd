package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGEDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SGEServiceTest {

    private SGEService sgeServiceUnderTest;

    @BeforeEach
    void setUp() {
        sgeServiceUnderTest = new SGEService();
        sgeServiceUnderTest.sgeDao = mock(SGEDao.class);
    }

    @Test
    void testSaveSGE() {
        // Setup
        final SGE sge = new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation"));

        // Configure SGEDao.save(...).
        final SGE sge1 = new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation"));
        when(sgeServiceUnderTest.sgeDao.save(any(SGE.class))).thenReturn(sge1);

        // Run the test
        sgeServiceUnderTest.saveSGE(sge);

        // Verify the results
    }

    @Test
    void testSaveSGE_SGEDaoReturnsNull() {
        // Setup
        final SGE sge = new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation"));
        when(sgeServiceUnderTest.sgeDao.save(any(SGE.class))).thenReturn(null);

        // Run the test
        sgeServiceUnderTest.saveSGE(sge);

        // Verify the results
    }

    @Test
    void testFindAll() {
        // Setup

        // Configure SGEDao.findAll(...).
        final List<SGE> sges = Arrays.asList(new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")));
        when(sgeServiceUnderTest.sgeDao.findAll()).thenReturn(sges);

        // Run the test
        final List<SGE> result = sgeServiceUnderTest.findAll();

        // Verify the results
    }

    @Test
    void testFindAllPageable() {
        // Setup

        // Configure SGEDao.findAll(...).
        final Page<SGE> sges = new PageImpl<>(Arrays.asList(new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation"))));
        when(sgeServiceUnderTest.sgeDao.findAll(any(Pageable.class))).thenReturn(sges);

        // Run the test
        final Page<SGE> result = sgeServiceUnderTest.findAllPageable(PageRequest.of(0, 1));

        // Verify the results
    }
}
