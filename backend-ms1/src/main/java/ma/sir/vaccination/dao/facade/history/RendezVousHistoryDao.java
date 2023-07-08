package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.RendezVousHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousHistoryDao extends AbstractHistoryRepository<RendezVousHistory,Long> {

}
