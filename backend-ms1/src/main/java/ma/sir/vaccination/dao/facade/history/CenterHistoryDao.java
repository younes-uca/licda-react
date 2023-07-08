package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.CenterHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterHistoryDao extends AbstractHistoryRepository<CenterHistory,Long> {

}
