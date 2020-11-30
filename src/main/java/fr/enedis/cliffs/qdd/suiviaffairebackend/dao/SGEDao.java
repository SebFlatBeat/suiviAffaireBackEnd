package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SGEDao extends JpaRepository<SGE, Long> {

    SGE save(SGE sge);

}
