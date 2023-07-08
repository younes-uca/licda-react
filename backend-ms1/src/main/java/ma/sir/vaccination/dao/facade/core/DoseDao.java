package ma.sir.vaccination.dao.facade.core;

import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.Dose;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DoseDao extends AbstractRepository<Dose,Long>  {

    List<Dose> findByRendezVousId(Long id);
    int deleteByRendezVousId(Long id);
    List<Dose> findByEtatDoseId(Long id);
    int deleteByEtatDoseId(Long id);

}
