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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
    void testSaveBlocage() {
        // Setup
        final Blocage blocage = new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE);

        // Configure BlocageDao.save(...).
        final Blocage blocage1 = new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE);
        when(blocageServiceUnderTest.blocageDao.save(any(Blocage.class))).thenReturn(blocage1);

        // Run the test
        blocageServiceUnderTest.saveBlocage(blocage);

        // Verify the results
    }

    @Test
    void testSaveBlocage_BlocageDaoReturnsNull() {
        // Setup
        final Blocage blocage = new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE);
        when(blocageServiceUnderTest.blocageDao.save(any(Blocage.class))).thenReturn(null);

        // Run the test
        blocageServiceUnderTest.saveBlocage(blocage);

        // Verify the results
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
    void testFindById_BlocageDaoReturnsNull() {
        // Setup
        when(blocageServiceUnderTest.blocageDao.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Blocage> result = blocageServiceUnderTest.findById(0L);

        // Verify the results
    }

    @Test
    void testUpdateBlocage() {
        // Setup

        // Configure BlocageDao.findById(...).
        final Optional<Blocage> blocage = Optional.of(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE));
        when(blocageServiceUnderTest.blocageDao.findById(0L)).thenReturn(blocage);

        // Configure UserAppService.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(blocageServiceUnderTest.userAppService.findByUsername("username")).thenReturn(userApp);

        // Configure BlocageDao.save(...).
        final Blocage blocage1 = new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE);
        when(blocageServiceUnderTest.blocageDao.save(any(Blocage.class))).thenReturn(blocage1);

        // Run the test
        blocageServiceUnderTest.updateBlocage(0L, "choix", "username");

        // Verify the results
    }

    @Test
    void testUpdateBlocage_BlocageDaoFindByIdReturnsNull() {
        // Setup
        when(blocageServiceUnderTest.blocageDao.findById(0L)).thenReturn(Optional.empty());

        // Configure UserAppService.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(blocageServiceUnderTest.userAppService.findByUsername("username")).thenReturn(userApp);

        // Configure BlocageDao.save(...).
        final Blocage blocage = new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE);
        when(blocageServiceUnderTest.blocageDao.save(any(Blocage.class))).thenReturn(blocage);

        // Run the test
        blocageServiceUnderTest.updateBlocage(0L, "choix", "username");

        // Verify the results
    }

    @Test
    void testUpdateBlocage_UserAppServiceReturnsAbsent() {
        // Setup

        // Configure BlocageDao.findById(...).
        final Optional<Blocage> blocage = Optional.of(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE));
        when(blocageServiceUnderTest.blocageDao.findById(0L)).thenReturn(blocage);

        when(blocageServiceUnderTest.userAppService.findByUsername("username")).thenReturn(Optional.empty());

        // Configure BlocageDao.save(...).
        final Blocage blocage1 = new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE);
        when(blocageServiceUnderTest.blocageDao.save(any(Blocage.class))).thenReturn(blocage1);

        // Run the test
        blocageServiceUnderTest.updateBlocage(0L, "choix", "username");

        // Verify the results
    }

    @Test
    void testUpdateBlocage_BlocageDaoSaveReturnsNull() {
        // Setup

        // Configure BlocageDao.findById(...).
        final Optional<Blocage> blocage = Optional.of(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE));
        when(blocageServiceUnderTest.blocageDao.findById(0L)).thenReturn(blocage);

        // Configure UserAppService.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(blocageServiceUnderTest.userAppService.findByUsername("username")).thenReturn(userApp);

        when(blocageServiceUnderTest.blocageDao.save(any(Blocage.class))).thenReturn(null);

        // Run the test
        blocageServiceUnderTest.updateBlocage(0L, "choix", "username");

        // Verify the results
    }

    @Test
    void testFilter() {
        // Setup
        final FilterForm filterForm = new FilterForm("numeroAffaire", "prm", "idc", "portefeuille", "etatContractuel", "etatAffaire", "blocageSource");

        // Configure BlocageDao.findByfilter(...).
        final Page<Blocage> blocages = new PageImpl<>(Arrays.asList(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE)));
        when(blocageServiceUnderTest.blocageDao.findByfilter(eq("numeroAffaire"), eq(0L), eq(0L), eq("portefeuille"), eq("etatContractuel"), eq("etatAffaire"), eq(BlocageSource.NONTRAITE), any(Pageable.class))).thenReturn(blocages);

        // Run the test
        final Page<Blocage> result = blocageServiceUnderTest.filter(filterForm, PageRequest.of(0, 1));

        // Verify the results
    }

    @Test
    void testPercent() {
        // Setup

        // Configure BlocageDao.findAll(...).
        final List<Blocage> blocages = Arrays.asList(new Blocage(0L, new UserApp(0L, "username", "password", "email"), new SGE(0L, "numeroAffaire", 0L, 0L, "portefeuille", "prestation", "contratDemande", "contratInitial", new COSY(0L, "numeroAffaire", "etatAffaire", "intervention"), new GEC(0L, 0L, "etatContractuel", "modeReleve", 0L, "statutDt", "prestationRealise", "realisation")), BlocageSource.NONTRAITE));
        when(blocageServiceUnderTest.blocageDao.findAll()).thenReturn(blocages);

        when(blocageServiceUnderTest.percentageCalculator.caculPercentage(0, 0)).thenReturn(0);

        // Run the test
        final int[] result = blocageServiceUnderTest.percent();

        // Verify the results
        assertThat(result).isEqualTo(new int[]{0});
    }
}
