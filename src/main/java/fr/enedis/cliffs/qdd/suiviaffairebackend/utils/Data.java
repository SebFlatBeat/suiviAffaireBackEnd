package fr.enedis.cliffs.qdd.suiviaffairebackend.utils;

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

    public void parsing(){
        try {
            reader.readFileGEC(inputGECFile);
            reader.readFileCOSY(inputCOSYFile);
            reader.readFileSGE(inputSGEFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
