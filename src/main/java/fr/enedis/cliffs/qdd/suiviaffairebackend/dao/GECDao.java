package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GECDao extends JpaRepository<GEC,Long> {

    GEC save(GEC gec);
}
