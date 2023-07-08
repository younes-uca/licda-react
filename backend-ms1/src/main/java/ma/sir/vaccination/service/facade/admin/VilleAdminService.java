package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Ville;
import ma.sir.vaccination.dao.criteria.core.VilleCriteria;
import ma.sir.vaccination.dao.criteria.history.VilleHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface VilleAdminService extends  IService<Ville,VilleCriteria, VilleHistoryCriteria>  {




}
