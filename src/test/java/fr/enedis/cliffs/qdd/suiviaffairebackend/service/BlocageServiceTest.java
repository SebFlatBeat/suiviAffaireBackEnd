package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.BlocageDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.*;
import fr.enedis.cliffs.qdd.suiviaffairebackend.utils.PercentageCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BlocageServiceTest {

    private BlocageService blocageServiceUnderTest;

    @BeforeEach
    void setUp() {
        blocageServiceUnderTest = new BlocageService();
        blocageServiceUnderTest.blocageDao = mock(BlocageDao.class);
        blocageServiceUnderTest.userAppService = mock(UserAppService.class);
        blocageServiceUnderTest.percentageCalculator = mock(PercentageCalculator.class);
    }


    @Test
    void testFindAllPageable() {
        // Setup

        // Configure BlocageDao.findAll(...).
        final Page<Blocage> blocages = new PageImpl<>(Arrays.asList(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE)));
        when(blocageServiceUnderTest.blocageDao.findAll(any(Pageable.class))).thenReturn(blocages);

        // Run the test
        final Page<Blocage> result = blocageServiceUnderTest.findAllPageable(PageRequest.of(0, 1));

        // Verify the results
    }

    @Test
    void testFindById() {
        // Setup

        // Configure BlocageDao.findById(...).
        final Optional<Blocage> blocage = Optional.of(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE));
        when(blocageServiceUnderTest.blocageDao.findById(0L)).thenReturn(blocage);

        // Run the test
        final Optional<Blocage> result = blocageServiceUnderTest.findById(0L);

        // Verify the results
    }


    @Test
    void testFilter() {
        // Setup
        final FilterForm filterForm = new FilterForm("numeroAffaire", "000000", "000000", "portefeuille", "etatContractuel", "etatAffaire", "NONTRAITE");

        // Configure BlocageDao.findByfilter(...).
        final Page<Blocage> blocages = new PageImpl<>(Collections.singletonList(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE)));
        when(blocageServiceUnderTest.blocageDao.findByfilter(eq("numeroAffaire"), eq(0L), eq(0L), eq("portefeuille"), eq("etatContractuel"), eq("etatAffaire"), eq(BlocageSource.NONTRAITE), any(Pageable.class))).thenReturn(blocages);

        // Run the test
        final Page<Blocage> result = blocageServiceUnderTest.filter(filterForm, PageRequest.of(0, 1));

        // Verify the results
        assertEquals(blocages, result);
    }

    @Test
    void testPercent() {
        // Configure BlocageDao.findAll(...).
        final List<Blocage> blocagesPercent = Arrays.asList(
                new Blocage(0L,
                        new UserApp(0L, "username", "password", "email"),
                        new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial",
                                new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"),
                                new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE),
                new Blocage(1L,
                        new UserApp(1L, "username", "password", "email"),
                        new SGE(1L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial",
                                new COSY(1L, "numeroAffaire", "etatAffaire", "intervention"),
                                new GEC(1L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE),
                new Blocage(2L,
                        new UserApp(2L, "username", "password", "email"),
                        new SGE(2L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial",
                                new COSY(2L, "numeroAffaire", "etatAffaire", "intervention"),
                                new GEC(2L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE),
                new Blocage(3L,
                        new UserApp(3L, "username", "password", "email"),
                        new SGE(3L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial",
                                new COSY(3L, "numeroAffaire", "etatAffaire", "intervention"),
                                new GEC(3L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE)
        );
        when(blocageServiceUnderTest.blocageDao.findAll()).thenReturn(blocagesPercent);

        when(blocageServiceUnderTest.percentageCalculator.caculPercentage(0, 0)).thenReturn(0);

        // Run the test
        final int[] result = blocageServiceUnderTest.percent();

        // Verify the results
        assertThat(result).isEqualTo(new int[]{0,0,0,0});
    }

}
