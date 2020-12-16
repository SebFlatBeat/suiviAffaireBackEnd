package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocageDao extends JpaRepository<Blocage, Long> {

    Page<Blocage> findAll(Pageable pageable);

    Blocage save(Blocage blocage);

}
