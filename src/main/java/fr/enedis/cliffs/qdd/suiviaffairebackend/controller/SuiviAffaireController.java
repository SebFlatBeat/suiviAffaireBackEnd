package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.AllDataListDto;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.AllDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SuiviAffaireController {


    @Autowired
    AllDataService allDataService;

    @GetMapping("synthese")
    public AllDataListDto getAllData(){
        return allDataService.findAllData();
    }
}
