package ma.sir.vaccination.dao.facade.core;

import ma.sir.vaccination.zynerator.repository.AbstractRepository;
import ma.sir.vaccination.bean.core.EffetIndesirable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EffetIndesirableDao extends AbstractRepository<EffetIndesirable,Long>  {

    List<EffetIndesirable> findByRendezVousId(Long id);
    int deleteByRendezVousId(Long id);

}
