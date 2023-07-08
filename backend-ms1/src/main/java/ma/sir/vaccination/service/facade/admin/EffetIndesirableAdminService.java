package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.EffetIndesirable;
import ma.sir.vaccination.dao.criteria.core.EffetIndesirableCriteria;
import ma.sir.vaccination.dao.criteria.history.EffetIndesirableHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;

import ma.sir.vaccination.ws.dto.EffetIndesirableDto;
import org.springframework.http.HttpEntity;

public interface EffetIndesirableAdminService extends  IService<EffetIndesirable,EffetIndesirableCriteria, EffetIndesirableHistoryCriteria>  {

    List<EffetIndesirable> findByRendezVousId(Long id);
    int deleteByRendezVousId(Long id);

    HttpEntity<byte[]> createPdf(EffetIndesirableDto dto) throws Exception;


}
