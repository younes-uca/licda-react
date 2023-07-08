package ma.sir.vaccination.dao.facade.history;

import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.bean.history.PatientHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHistoryDao extends AbstractHistoryRepository<PatientHistory,Long> {

}
