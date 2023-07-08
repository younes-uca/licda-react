package ma.sir.vaccination.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.Patient;
import org.springframework.stereotype.Repository;
import ma.sir.vaccination.bean.core.Patient;
import java.util.List;


@Repository
public interface PatientDao extends AbstractRepository<Patient,Long>  {
    Patient findByIpp(String ipp);
    int deleteByIpp(String ipp);

    List<Patient> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    List<Patient> findByGenderId(Long id);
    int deleteByGenderId(Long id);

    @Query("SELECT NEW Patient(item.id,item.email) FROM Patient item")
    List<Patient> findAllOptimized();
}
