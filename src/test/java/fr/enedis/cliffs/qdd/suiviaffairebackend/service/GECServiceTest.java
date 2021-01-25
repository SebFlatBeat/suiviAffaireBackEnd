package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.GECDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GECServiceTest {

    private GECService gecServiceUnderTest;

    private List<GEC> gecTest = new ArrayList<>();

    @BeforeEach
    void setUp() {
        gecServiceUnderTest = new GECService();
        gecServiceUnderTest.gecDao = mock(GECDao.class);
        GEC gec = new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation");
        gecTest.add(gec);
        GEC gec1 = new GEC(1L, 1L, "etatContractuel1", "modeReleve1", 1L, "statutDt1", "prestationRealise1", "realisation1");
        gecTest.add(gec1);
        Mockito.when(gecServiceUnderTest.gecDao.findAll()).thenReturn(gecTest);
    }


    @Test
    void testFindAll() {
        // Configure GECDao.findAll(...).
        final List<GEC> gecs = gecTest;

        // Run the test
        final List<GEC> result = gecServiceUnderTest.findAll();

        // Verify the results
        assertEquals(gecs, result);
    }
}
