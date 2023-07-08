package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.RendezVous;
import ma.sir.vaccination.dao.criteria.core.RendezVousCriteria;
import ma.sir.vaccination.dao.criteria.history.RendezVousHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;

import ma.sir.vaccination.ws.dto.RendezVousDto;
import org.springframework.http.HttpEntity;

public interface RendezVousAdminService extends  IService<RendezVous,RendezVousCriteria, RendezVousHistoryCriteria>  {

    List<RendezVous> findByPatientId(Long id);
    int deleteByPatientId(Long id);
    List<RendezVous> findByCenterId(Long id);
    int deleteByCenterId(Long id);
    List<RendezVous> findByMedecinId(Long id);
    int deleteByMedecinId(Long id);
    List<RendezVous> findByCategorieRdvId(Long id);
    int deleteByCategorieRdvId(Long id);
    List<RendezVous> findByEtatRendezVousId(Long id);
    int deleteByEtatRendezVousId(Long id);

    HttpEntity<byte[]> createPdf(RendezVousDto dto) throws Exception;


}
