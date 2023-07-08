package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.DoseHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseHistoryDao extends AbstractHistoryRepository<DoseHistory,Long> {

}
