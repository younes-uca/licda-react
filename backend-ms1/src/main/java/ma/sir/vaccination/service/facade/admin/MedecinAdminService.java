package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Medecin;
import ma.sir.vaccination.dao.criteria.core.MedecinCriteria;
import ma.sir.vaccination.dao.criteria.history.MedecinHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;

import ma.sir.vaccination.ws.dto.MedecinDto;
import org.springframework.http.HttpEntity;

public interface MedecinAdminService extends  IService<Medecin,MedecinCriteria, MedecinHistoryCriteria>  {

    List<Medecin> findByCenterId(Long id);
    int deleteByCenterId(Long id);

    HttpEntity<byte[]> createPdf(MedecinDto dto) throws Exception;


}
