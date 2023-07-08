package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.MedecinHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinHistoryDao extends AbstractHistoryRepository<MedecinHistory,Long> {

}
