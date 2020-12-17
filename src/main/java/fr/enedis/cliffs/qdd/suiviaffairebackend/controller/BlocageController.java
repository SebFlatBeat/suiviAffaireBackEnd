package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;


import fr.enedis.cliffs.qdd.suiviaffairebackend.service.BlocageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BlocageController {

    @Autowired
    BlocageService blocageService;

    @PutMapping("blocage")
    public void updateBlocage(@RequestParam Long id, @RequestParam String choix) {
        blocageService.updateBlocage(id, choix);
    }

}
