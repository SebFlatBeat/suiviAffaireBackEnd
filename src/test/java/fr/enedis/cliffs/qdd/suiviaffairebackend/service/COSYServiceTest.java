package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.COSYDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class COSYServiceTest {

    private COSYService cosyServiceUnderTest;

    @BeforeEach
    void setUp() {
        cosyServiceUnderTest = new COSYService();
        cosyServiceUnderTest.cosyDao = mock(COSYDao.class);
    }

    @Test
    void testSaveCOSY() {
        // Setup
        final COSY cosy = new COSY(0L, "numeroAffaire", "etatAffaire", "intervention");

        // Configure COSYDao.save(...).
        final COSY cosy1 = new COSY(0L, "numeroAffaire", "etatAffaire", "intervention");
        when(cosyServiceUnderTest.cosyDao.save(any(COSY.class))).thenReturn(cosy1);

        // Run the test
        cosyServiceUnderTest.saveCOSY(cosy);

        // Verify the results
    }

    @Test
    void testSaveCOSY_COSYDaoReturnsNull() {
        // Setup
        final COSY cosy = new COSY(0L, "numeroAffaire", "etatAffaire", "intervention");
        when(cosyServiceUnderTest.cosyDao.save(any(COSY.class))).thenReturn(null);

        // Run the test
        cosyServiceUnderTest.saveCOSY(cosy);

        // Verify the results
    }

    @Test
    void testFindAll() {
        // Setup

        // Configure COSYDao.findAll(...).
        final List<COSY> cosies = Arrays.asList(new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"));
        when(cosyServiceUnderTest.cosyDao.findAll()).thenReturn(cosies);

        // Run the test
        final List<COSY> result = cosyServiceUnderTest.findAll();

        // Verify the results
    }
}
