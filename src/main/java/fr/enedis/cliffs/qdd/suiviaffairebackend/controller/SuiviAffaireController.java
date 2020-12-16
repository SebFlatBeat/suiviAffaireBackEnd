package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.FilterForm;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
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

    @GetMapping("analyse")
    public Page<SGE> sgePagined() {
        Pageable pageable = PageRequest.of(0, 5);
        return sgeService.findAllPageable(pageable);
    }

    @GetMapping("/filter")
    public Page<SGE> filter(FilterForm filterForm) {
        Page<SGE> sgeList = sgeService.filter(filterForm);
        return sgeList;
    }
}
