package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.Medecin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MedecinDao extends AbstractRepository<Medecin,Long>  {

    List<Medecin> findByCenterId(Long id);
    int deleteByCenterId(Long id);

    @Query("SELECT NEW Medecin(item.id,item.email) FROM Medecin item")
    List<Medecin> findAllOptimized();
}
