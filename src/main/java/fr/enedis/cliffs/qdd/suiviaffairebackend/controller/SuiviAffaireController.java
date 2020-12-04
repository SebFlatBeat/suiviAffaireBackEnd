package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.AllDataListDto;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.AllDataService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.GECService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuiviAffaireController {

    @Autowired
    SGEService sgeService;

    @Autowired
    SGOService sgoService;

    @Autowired
    GECService gecService;

    @Autowired
    AllDataService allDataService;

    @GetMapping("synthese")
    public AllDataListDto getAllData(){
        return allDataService.findAllData();
    }
}
