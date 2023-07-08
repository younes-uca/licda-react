package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.Quartier;
import org.springframework.stereotype.Repository;
import ma.sir.vaccination.bean.core.Quartier;
import java.util.List;


@Repository
public interface QuartierDao extends AbstractRepository<Quartier,Long>  {
    Quartier findByCode(String code);
    int deleteByCode(String code);

    List<Quartier> findByVilleId(Long id);
    int deleteByVilleId(Long id);

    @Query("SELECT NEW Quartier(item.id,item.libelle) FROM Quartier item")
    List<Quartier> findAllOptimized();
}
