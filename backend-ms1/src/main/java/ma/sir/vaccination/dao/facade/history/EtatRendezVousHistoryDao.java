package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.EtatRendezVousHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatRendezVousHistoryDao extends AbstractHistoryRepository<EtatRendezVousHistory,Long> {

}
