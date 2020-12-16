package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.GEC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GECDao extends JpaRepository<GEC,Long> {

    GEC save(GEC gec);

    List<GEC> findAll();

    Page<GEC> findAll( Pageable pageable);
}
