package fr.enedis.cliffs.qdd.suiviaffairebackend.utils;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.*;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.BlocageService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.GECService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.COSYService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;


@Service
public class Reader {
    @Autowired
    SGEService sgeService;

    @Autowired
    GECService gecService;

    @Autowired
    COSYService cosyService;

    @Autowired
    BlocageService blocageService;

    private static final Logger LOG = LoggerFactory.getLogger(Reader.class);

    public void readFileGEC(String csvFile) {
        LOG.debug("Start read GEC File");
        try {
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String line;
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                GEC gec = new GEC();
                line = scanner.nextLine();
                String[] results = line.split(";", -5);
                Long num1 = Long.parseLong(results[0]);
                if (!results[3].isEmpty()) {
                    Long num2 = Long.parseLong(results[3]);
                    gec.setNumeroDt(num2);
                }
                gec.setIdc(num1);
                gec.setEtatContractuel(results[1]);
                gec.setModeReleve(results[2]);
                gec.setStatutDt(results[4]);
                gec.setPrestationRealise(results[5]);
                gec.setRealisation(results[6]);
                gecService.saveGEC(gec);
            }
            scanner.close();
            LOG.info("Done to read GEC File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

    public void readFileCOSY(String csvFile) {
        LOG.debug("Start read COSY File");
        try {
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String line;
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                COSY cosy = new COSY();
                line = scanner.nextLine();
                String[] results = line.split(";", -1);
                cosy.setNumeroAffaire(results[0]);
                cosy.setEtatAffaire(results[1]);
                cosy.setIntervention(results[2]);
                cosyService.saveCOSY(cosy);
            }
            scanner.close();
            LOG.info("Done to read COSY File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

    public void readFileSGE(String csvFile) {
        LOG.debug("Start read SGE File");
        try {
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String line;
            scanner.nextLine();
            List<GEC> gecList = gecService.findAll();
            List<COSY> cosyList = cosyService.findAll();
            while (scanner.hasNextLine()) {
                SGE sge = new SGE();
                Blocage blocage = new Blocage();
                line = scanner.nextLine();
                String[] results = line.split(";");
                Long num1 = Long.parseLong(results[1]);
                Long num2 = Long.parseLong(results[2]);
                sge.setNumeroAffaire(results[0]);
                sge.setPrm(num1);
                sge.setIdc(num2);
                sge.setPortefeuille(results[3]);
                sge.setPrestation(results[4]);
                sge.setContratDemande(results[5]);
                sge.setContratInitial(results[6]);
                for (GEC g : gecList) {
                    if (g.getIdc().equals(sge.getIdc())) {
                        sge.setGec(g);
                    }
                }
                for (COSY c : cosyList) {
                    if (c.getNumeroAffaire().equals(sge.getNumeroAffaire())) {
                        sge.setCosy(c);
                    }
                }
                sgeService.saveSGE(sge);
                blocage.setSge(sge);
                blocage.setBlocageSource(BlocageSource.NONTRAITE);
                blocageService.saveBlocage(blocage);
            }
            scanner.close();
            LOG.info("Done to read SGE File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }
}
