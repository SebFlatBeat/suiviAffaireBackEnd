package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.BlocageService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

    @GetMapping("filter")
    public Page<SGE> filter(FilterForm filterForm) {
        Pageable pageable = PageRequest.of(0, 5);
        return sgeService.filter(filterForm, pageable);
    }

    @GetMapping("synthese")
    public int[] blocagesPercent() {
        return blocageService.percent();
    }

    @GetMapping("user")
    public Optional<UserApp> userApp(@RequestParam String userApp){
        return userAppService.findByUsername(userApp);
    }
}
