package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.CategorieRdvHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRdvHistoryDao extends AbstractHistoryRepository<CategorieRdvHistory,Long> {

}
