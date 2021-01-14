package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.NotNniException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserExistException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserNotFoundException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.WrongPasswordException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.BlocageService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SuiviAffaireController {

    @Autowired
    SGEService sgeService;

    @Autowired
    BlocageService blocageService;

    @Autowired
    UserAppService userAppService;

    @GetMapping("analyse")
    public Page<Blocage> blocagePagined() {
        Pageable pageable = PageRequest.of(0, 5);
        return blocageService.findAllPageable(pageable);
    }

    @PostMapping("filter")
    public Page<Blocage> filter(@RequestBody FilterForm filterForm) {
        Pageable pageable = PageRequest.of(0, 5);
        return blocageService.filter(filterForm, pageable);
    }

    @GetMapping("synthese")
    public int[] blocagesPercent() {
        return blocageService.percent();
    }

    @GetMapping("user")
    public UserApp userApp(@RequestParam String userApp, @RequestParam String password) throws UserNotFoundException, WrongPasswordException {
        return userAppService.findByUsernameAndPassword(userApp, password);
    }

    @PostMapping("register")
    public void newUser(@RequestParam String username,
                        @RequestParam String password, @RequestParam String email)
            throws UserExistException, NotNniException {
        userAppService.saveNewUser(username, password, email);
    }

    @PostMapping("/logout")
    public void userLogout() {
    // default implementation
    }
}
