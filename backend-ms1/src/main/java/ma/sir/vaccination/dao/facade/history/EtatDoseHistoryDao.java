package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.EtatDoseHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDoseHistoryDao extends AbstractHistoryRepository<EtatDoseHistory,Long> {

}
