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

    @Value("${inputSGOFile}")
    String inputSGOFile;

    @Autowired
    Reader reader;

    public void parsing(){
        try {
            reader.readFileSGE(inputSGEFile);
            reader.readFileGEC(inputGECFile);
            reader.readFileSGO(inputSGOFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
