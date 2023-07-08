package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.EtatRendezVous;
import org.springframework.stereotype.Repository;
import ma.sir.vaccination.bean.core.EtatRendezVous;
import java.util.List;


@Repository
public interface EtatRendezVousDao extends AbstractRepository<EtatRendezVous,Long>  {
    EtatRendezVous findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatRendezVous(item.id,item.libelle) FROM EtatRendezVous item")
    List<EtatRendezVous> findAllOptimized();
}
