package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Dose;
import ma.sir.vaccination.dao.criteria.core.DoseCriteria;
import ma.sir.vaccination.dao.criteria.history.DoseHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;

import ma.sir.vaccination.ws.dto.DoseDto;
import org.springframework.http.HttpEntity;

public interface DoseAdminService extends  IService<Dose,DoseCriteria, DoseHistoryCriteria>  {

    List<Dose> findByRendezVousId(Long id);
    int deleteByRendezVousId(Long id);
    List<Dose> findByEtatDoseId(Long id);
    int deleteByEtatDoseId(Long id);

    HttpEntity<byte[]> createPdf(DoseDto dto) throws Exception;


}
