package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Patient;
import ma.sir.vaccination.dao.criteria.core.PatientCriteria;
import ma.sir.vaccination.dao.criteria.history.PatientHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;

import ma.sir.vaccination.ws.dto.PatientDto;
import org.springframework.http.HttpEntity;

public interface PatientAdminService extends  IService<Patient,PatientCriteria, PatientHistoryCriteria>  {

    List<Patient> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    List<Patient> findByGenderId(Long id);
    int deleteByGenderId(Long id);

    HttpEntity<byte[]> createPdf(PatientDto dto) throws Exception;


}
