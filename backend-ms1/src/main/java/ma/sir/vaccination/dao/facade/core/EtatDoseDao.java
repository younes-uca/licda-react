package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.EtatDose;
import org.springframework.stereotype.Repository;
import ma.sir.vaccination.bean.core.EtatDose;
import java.util.List;


@Repository
public interface EtatDoseDao extends AbstractRepository<EtatDose,Long>  {
    EtatDose findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatDose(item.id,item.libelle) FROM EtatDose item")
    List<EtatDose> findAllOptimized();
}
