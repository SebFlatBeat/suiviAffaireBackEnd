package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SGODao extends JpaRepository<SGO, Long> {

    SGO save(SGO sgo);

    List<SGO>findAll();

    Page<SGO>findAll(Pageable pageable);
}
