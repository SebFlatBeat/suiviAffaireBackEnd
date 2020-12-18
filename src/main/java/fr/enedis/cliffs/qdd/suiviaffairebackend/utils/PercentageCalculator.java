package fr.enedis.cliffs.qdd.suiviaffairebackend.utils;

import org.springframework.stereotype.Service;

@Service
public class PercentageCalculator {

    public int caculPercentage(int nbre, int total){
        return nbre * 100/total;
    }

}
