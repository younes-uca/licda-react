package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.Center;
import org.springframework.stereotype.Repository;
import ma.sir.vaccination.bean.core.Center;
import java.util.List;


@Repository
public interface CenterDao extends AbstractRepository<Center,Long>  {
    Center findByCode(String code);
    int deleteByCode(String code);

    List<Center> findByQuartierId(Long id);
    int deleteByQuartierId(Long id);

    @Query("SELECT NEW Center(item.id,item.libelle) FROM Center item")
    List<Center> findAllOptimized();
}
