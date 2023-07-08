package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.CategorieRdv;
import ma.sir.vaccination.dao.criteria.core.CategorieRdvCriteria;
import ma.sir.vaccination.dao.criteria.history.CategorieRdvHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface CategorieRdvAdminService extends  IService<CategorieRdv,CategorieRdvCriteria, CategorieRdvHistoryCriteria>  {




}
