package fr.enedis.cliffs.qdd.suiviaffairebackend.controller;

import fr.enedis.cliffs.qdd.suiviaffairebackend.beans.AllDataListBean;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.GECService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGEService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.service.SGOService;
import fr.enedis.cliffs.qdd.suiviaffairebackend.utils.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuiviAffaireController {

    @Autowired
    Data data;

    @Autowired
    SGEService sgeService;

    @Autowired
    SGOService sgoService;

    @Autowired
    GECService gecService;

    @GetMapping("getFiles")
    public void getFiles(){
        data.parsing();
    }

    @GetMapping("synthese")
    public AllDataListBean allData(){
        List <SGE> sgeList = sgeService.findAll();
        List <SGO> sgoList = sgoService.findAll();
        List <GEC> gecList = gecService.findAll();
        AllDataListBean allDataListBean = new AllDataListBean();
        allDataListBean.setSge(sgeList);
        allDataListBean.setSgo(sgoList);
        allDataListBean.setGec(gecList);
        return allDataListBean;
    }
}
