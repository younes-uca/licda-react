package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.EffetIndesirableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EffetIndesirableHistoryDao extends AbstractHistoryRepository<EffetIndesirableHistory,Long> {

}
