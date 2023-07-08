package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.CategorieRdv;
import org.springframework.stereotype.Repository;
import ma.sir.vaccination.bean.core.CategorieRdv;
import java.util.List;


@Repository
public interface CategorieRdvDao extends AbstractRepository<CategorieRdv,Long>  {
    CategorieRdv findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CategorieRdv(item.id,item.libelle) FROM CategorieRdv item")
    List<CategorieRdv> findAllOptimized();
}
