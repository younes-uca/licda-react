package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Quartier;
import ma.sir.vaccination.dao.criteria.core.QuartierCriteria;
import ma.sir.vaccination.dao.criteria.history.QuartierHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface QuartierAdminService extends  IService<Quartier,QuartierCriteria, QuartierHistoryCriteria>  {

    List<Quartier> findByVilleId(Long id);
    int deleteByVilleId(Long id);



}
