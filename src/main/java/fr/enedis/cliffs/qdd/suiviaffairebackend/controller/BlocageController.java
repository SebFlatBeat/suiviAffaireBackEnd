package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;


import fr.enedis.cliffs.qdd.suiviaffairebackend.service.BlocageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BlocageController {

    @Autowired
    BlocageService blocageService;

    private static final Logger LOG = LoggerFactory.getLogger(BlocageController.class);

    @PutMapping("blocage")
    public void updateBlocage(@RequestParam Long id, @RequestParam String choix, @RequestParam String username) {
        LOG.info("Mise à jour du blocage");
        blocageService.updateBlocage(id, choix, username);
    }
}
