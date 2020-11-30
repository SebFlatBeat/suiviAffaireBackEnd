package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.utils.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuiviAffaireController {

    @Autowired
    Data data;

    @GetMapping("getFiles")
    public void getFiles(){
        data.parsing();
    }
}
