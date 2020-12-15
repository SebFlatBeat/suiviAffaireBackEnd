package fr.enedis.cliffs.qdd.suiviaffairebackend.dao;

import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.SGE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SGEDao extends JpaRepository<SGE, Long> {

    SGE save(SGE sge);

    List<SGE> findAll();

    Page<SGE> findAll(Pageable pageable);

    @Query("SELECT s FROM SGE s WHERE (:numeroAffaire is null or s.numeroAffaire =:numeroAffaire) " +
            "and (:prm is null or s.prm =:prm) " +
            "and (:idc is null or s.idc =:idc) " +
            "and (:portefeuille is null or s.portefeuille =:portefeuille) " +
            "and (:prestation is null or s.prestation =:prestation) " +
            "and (:contratDemande is null or s.contratDemande =:contratDemande) " +
            "and (:contratInitial is null or s.contratInitial =:contratInitial) " +
            "and (:etatContractuel is null or s.gec.etatContractuel =:etatContractuel) " +
            "and (:modeReleve is null or s.gec.modeReleve =:modeReleve) " +
            "and (:numeroDt is null or s.gec.numeroDt =:numeroDt) " +
            "and (:statutDt is null or s.gec.statutDt =:statutDt) " +
            "and (:prestationRealise is null or s.gec.prestationRealise =:prestationRealise) " +
            "and (:realisation is null or s.gec.realisation =:realisation) " +
            "and (:etatAffaire is null or s.sgo.etatAffaire =:etatAffaire) " +
            "and (:intervention is null or s.sgo.intervention =:intervention)"
    )
    Page<SGE> filter(@Param("numeroAffaire") String numeroAffaire,
                     @Param("prm") Long prm,
                     @Param("idc") Long idc,
                     @Param("portefeuille") String portefeuille,
                     @Param("prestation") String prestation,
                     @Param("contratDemande") String contratDemande,
                     @Param("contratInitial") String contratInitial,
                     @Param("etatContractuel") String etatContractuel,
                     @Param("modeReleve") String modeReleve,
                     @Param("numeroDt") Long numeroDt,
                     @Param("statutDt") String statutDt,
                     @Param("prestationRealise") String prestationRealise,
                     @Param("realisation") String realisation,
                     @Param("etatAffaire") String etatAffaire,
                     @Param("intervention") String intervention
    );
}
