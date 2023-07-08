package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.QuartierHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartierHistoryDao extends AbstractHistoryRepository<QuartierHistory,Long> {

}
