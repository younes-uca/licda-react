package ma.sir.vaccination.dao.facade.core;

import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.RendezVous;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RendezVousDao extends AbstractRepository<RendezVous,Long>  {

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

}
