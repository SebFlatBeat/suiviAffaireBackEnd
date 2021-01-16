package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.BlocageResponse;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;


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
    public Page<BlocageResponse> blocagePagined(@RequestParam(name = "page", defaultValue = "0") int page,
                                                @RequestParam(name = "size", defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Blocage> pageResult = blocageService.findAllPageable(pageRequest);
        List<BlocageResponse> blocageResponses = pageResult
                .stream()
                .map(BlocageResponse::new)
                .collect(toList());
        return new PageImpl<>(blocageResponses, pageRequest, pageResult.getTotalElements());
    }

    @GetMapping("filter")
    public Page<BlocageResponse> filter(@RequestParam("numeroAffaire")
                                                String numeroAffaire,
                                        @RequestParam("prm")
                                                String prm,
                                        @RequestParam("idc")
                                                String idc,
                                        @RequestParam("portefeuille")
                                                String portefeuille,
                                        @RequestParam("etatContractuel")
                                                String etatContractuel,
                                        @RequestParam("etatAffaire")
                                                String etatAffaire,
                                        @RequestParam("blocageSource")
                                                String blocageSource,
                                        @RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "5") int size) {
        FilterForm filterForm = new FilterForm(numeroAffaire,prm ,idc ,portefeuille, etatContractuel, etatAffaire, blocageSource);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Blocage> pageResult = blocageService.filter(filterForm, pageRequest);
        List<BlocageResponse> blocageResponses = pageResult
                .stream()
                .map(BlocageResponse::new)
                .collect(toList());
        return new PageImpl<>(blocageResponses, pageRequest, pageResult.getTotalElements());
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
                        @RequestParam String password,
                        @RequestParam String email)
            throws UserExistException, NotNniException {
        userAppService.saveNewUser(username, password, email);
    }

    @PostMapping("/logout")
    public void userLogout() {
        // default implementation
    }
}
