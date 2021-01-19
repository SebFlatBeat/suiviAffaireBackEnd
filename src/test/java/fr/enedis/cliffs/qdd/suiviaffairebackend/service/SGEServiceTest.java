package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.SGEDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;


class SGEServiceTest {

    private SGEService sgeServiceUnderTest;

    private List<SGE> sgeTest = new ArrayList<>();

    private Page<SGE> sgePageTest = new PageImpl<SGE>(sgeTest);

    @BeforeEach
    void setUp() {
        sgeServiceUnderTest = new SGEService();
        sgeServiceUnderTest.sgeDao = mock(SGEDao.class);

        SGE sge = new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation"));
        sgeTest.add(sge);
        SGE sge1 = new SGE(1L, "numeroAffaire1", 1L, 1L, "portefeuille1", "prestation1", "contratDemande1", "contratInitial1", new COSY(1L, "numeroAffaire1", "etatAffaire1", "intervention1"), new GEC(1L, 1L, "etatContractuel1", "modeReleve1", 1L, "statutDt1", "prestationRealise1", "realisation1"));
        sgeTest.add(sge1);
        Mockito.when(sgeServiceUnderTest.sgeDao.findAll()).thenReturn(sgeTest);
        Mockito.when(sgeServiceUnderTest.sgeDao.findAll(any(Pageable.class))).thenReturn(sgePageTest);
    }

    @Test
    void testFindAll() {
        // Configure SGEDao.findAll(...).
        final List<SGE> sges = sgeTest;

        // Run the test
        final List<SGE> result = sgeServiceUnderTest.findAll();

        // Verify the results
        assertEquals(sges, result);
    }

    @Test
    void testFindAllPageable() {
        // Configure SGEDao.findAll(...).
        final Page<SGE> sges = sgePageTest;

        // Run the test
        final Page<SGE> result = sgeServiceUnderTest.findAllPageable(PageRequest.of(0, 1));

        // Verify the results
        assertEquals(sges, result);
    }
}
