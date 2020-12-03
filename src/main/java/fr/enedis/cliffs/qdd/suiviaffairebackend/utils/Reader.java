package fr.enedis.cliffs.qdd.suiviaffairebackend.utils;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.GECService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGOService;
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
    SGOService sgoService;


    public void readFileSGE(String csvFile){
        try {
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String skipHeader;
            String line;
            skipHeader = scanner.nextLine();
            while (scanner.hasNextLine()){
                SGE sge = new SGE();
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
                sgeService.saveSGE(sge);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void readFileGEC(String csvFile){
        try {
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String skipHeader;
            String line;
            skipHeader = scanner.nextLine();
            List<SGE> sgeList = sgeService.findAll();
            while (scanner.hasNextLine()){
                GEC gec = new GEC();
                line = scanner.nextLine();
                String[] results = line.split(";",-5);
                Long num1 = Long.parseLong(results[0]);
                if (!results[3].isEmpty()){
                    Long num2 = Long.parseLong(results[3]);
                    gec.setNumeroDt(num2);}
                gec.setIdc(num1);
                gec.setEtatContractuel(results[1]);
                gec.setModeReleve(results[2]);
                gec.setStatutDt(results[4]);
                gec.setPrestationRealise(results[5]);
                gec.setRealisation(results[6]);
                for(SGE s : sgeList){
                    if(s.getIdc().equals(gec.getIdc())){
                        gec.setSge(s);
                    }
                }
                gecService.saveGEC(gec);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void readFileSGO(String csvFile){
        try {
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String skipHeader;
            String line;
            skipHeader = scanner.nextLine();
            List<SGE> sgeList = sgeService.findAll();
            while (scanner.hasNextLine()){
                SGO sgo = new SGO();
                line = scanner.nextLine();
                String[] results = line.split(";",-1);
                sgo.setNumeroAffaire(results[0]);
                sgo.setEtatAffaire(results[1]);
                sgo.setIntervention(results[2]);
                for(SGE s : sgeList){
                    if(s.getNumeroAffaire().equals(sgo.getNumeroAffaire())){
                        sgo.setSge(s);
                    }
                }
                sgoService.saveSGO(sgo);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}