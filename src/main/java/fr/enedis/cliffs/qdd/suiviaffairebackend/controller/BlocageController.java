package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;


import fr.enedis.cliffs.qdd.suiviaffairebackend.service.BlocageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BlocageController {

    @Autowired
    BlocageService blocageService;

    @PostMapping("blocage/update")
    public void updateBlocage(@RequestParam Long id,@RequestParam Long userId, @RequestParam String choix) {
        blocageService.updateBlocage(id, userId, choix);
    }

}
