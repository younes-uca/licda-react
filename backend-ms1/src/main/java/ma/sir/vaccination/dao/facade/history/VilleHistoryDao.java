package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.VilleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleHistoryDao extends AbstractHistoryRepository<VilleHistory,Long> {

}
