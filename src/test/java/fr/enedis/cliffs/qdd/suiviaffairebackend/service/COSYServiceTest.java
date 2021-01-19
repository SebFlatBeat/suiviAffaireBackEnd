package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.COSYDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class COSYServiceTest {

    private COSYService cosyServiceUnderTest;

    private List<COSY> cosyTest = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cosyServiceUnderTest = new COSYService();
        cosyServiceUnderTest.cosyDao = mock(COSYDao.class);
        COSY cosy = new COSY(0L, "numeroAffaire", "etatAffaire", "intervention");
        cosyTest.add(cosy);
        COSY cosy1 = new COSY(1L, "numeroAffaire1", "etatAffaire1", "intervention1");
        cosyTest.add(cosy1);

        Mockito.when(cosyServiceUnderTest.cosyDao.findAll()).thenReturn(cosyTest);
    }

    @Test
    void testFindAll() {
        // Configure COSYDao.findAll(...).
        final List<COSY> cosies = cosyTest;

        // Run the test
        final List<COSY> result = cosyServiceUnderTest.findAll();

        // Verify the results
        assertEquals(cosies,result);
    }
}
