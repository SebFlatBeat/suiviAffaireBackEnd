package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.utils.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportDataController {

    @Autowired
    Data data;

    private static final Logger LOG = LoggerFactory.getLogger(ImportDataController.class);

    @GetMapping("getFiles")
    public void getFiles(){
        LOG.info("Récupération de la donnée");
        data.parsing();
    }
}
