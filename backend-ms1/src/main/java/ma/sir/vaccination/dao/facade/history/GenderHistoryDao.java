package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.GenderHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderHistoryDao extends AbstractHistoryRepository<GenderHistory,Long> {

}
