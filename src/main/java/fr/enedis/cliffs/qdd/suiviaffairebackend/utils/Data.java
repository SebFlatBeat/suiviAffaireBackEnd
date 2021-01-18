package fr.enedis.cliffs.qdd.suiviaffairebackend.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Data {
    @Value("${inputGECFile}")
    String inputGECFile;

    @Value("${inputSGEFile}")
    String inputSGEFile;

    @Value("${inputCOSYFile}")
    String inputCOSYFile;

    @Autowired
    Reader reader;

    private static final Logger LOG = LoggerFactory.getLogger(Data.class);

    public void parsing() {
        LOG.debug("Start parsing data");
        try {
            reader.readFileGEC(inputGECFile);
            reader.readFileCOSY(inputCOSYFile);
            reader.readFileSGE(inputSGEFile);
            LOG.info("Parsing data is done");
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
