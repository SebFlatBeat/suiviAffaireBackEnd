package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dto.AllDataListDto;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllDataService {

    @Autowired
    SGEService sgeService;

    @Autowired
    SGOService sgoService;

    @Autowired
    GECService gecService;

    public AllDataListDto findAllData(){
        List <SGE> sgeList = sgeService.findAll();
        List <SGO> sgoList = sgoService.findAll();
        List <GEC> gecList = gecService.findAll();
        AllDataListDto allDataListDto = new AllDataListDto();
        allDataListDto.setSge(sgeList);
        allDataListDto.setSgo(sgoList);
        allDataListDto.setGec(gecList);
        return allDataListDto;
    }

}
