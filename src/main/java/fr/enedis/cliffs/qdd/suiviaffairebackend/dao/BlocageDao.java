package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.Blocage;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.BlocageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BlocageDao extends PagingAndSortingRepository<Blocage, Long> {

    Page<Blocage> findAll(Pageable pageable);

    Blocage save(Blocage blocage);

    List<Blocage> findAll();

    @Query("SELECT b FROM Blocage b WHERE (:numeroAffaire is null or b.sge.numeroAffaire =:numeroAffaire) " +
            "and (:prm is null or b.sge.prm =:prm) " +
            "and (:idc is null or b.sge.idc =:idc) " +
            "and (:portefeuille is null or b.sge.portefeuille =:portefeuille) " +
            "and (:etatContractuel is null or b.sge.gec.etatContractuel =:etatContractuel) " +
            "and (:etatAffaire is null or b.sge.cosy.etatAffaire =:etatAffaire) " +
            "and (:blocageSource is null or b.blocageSource =:blocageSource)"
    )
    Page<Blocage> findByfilter(@Param("numeroAffaire") String numeroAffaire,
                               @Param("prm") Long prm,
                               @Param("idc") Long idc,
                               @Param("portefeuille") String portefeuille,
                               @Param("etatContractuel") String etatContractuel,
                               @Param("etatAffaire") String etatAffaire,
                               @Param("blocageSource") BlocageSource blocageSource,
                               Pageable pageable
    );
}
