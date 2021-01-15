package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.COSY;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface COSYDao extends JpaRepository<COSY, Long> {

    COSY save(COSY cosy);

    List<COSY>findAll();

    Page<COSY>findAll(Pageable pageable);
}
