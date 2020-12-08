package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.AllDataListDto;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.AllDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SuiviAffaireController {


    @Autowired
    AllDataService allDataService;

    @GetMapping("analyse")
    public AllDataListDto getAllData(){
        return allDataService.findAllData();
    }
}
