package fr.enedis.cliffs.qdd.suiviaffairebackend.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PercentageCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(PercentageCalculator.class);

    public int caculPercentage(int nbre, int total){
        LOG.trace("Percentage is calculate");
        return nbre * 100/total;
    }

}
