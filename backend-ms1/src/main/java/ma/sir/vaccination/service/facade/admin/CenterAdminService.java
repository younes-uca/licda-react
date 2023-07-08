package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Center;
import ma.sir.vaccination.dao.criteria.core.CenterCriteria;
import ma.sir.vaccination.dao.criteria.history.CenterHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface CenterAdminService extends  IService<Center,CenterCriteria, CenterHistoryCriteria>  {

    List<Center> findByQuartierId(Long id);
    int deleteByQuartierId(Long id);



}
