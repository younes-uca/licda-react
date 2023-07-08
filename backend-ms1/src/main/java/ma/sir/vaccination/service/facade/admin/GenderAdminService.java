package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.Gender;
import ma.sir.vaccination.dao.criteria.core.GenderCriteria;
import ma.sir.vaccination.dao.criteria.history.GenderHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface GenderAdminService extends  IService<Gender,GenderCriteria, GenderHistoryCriteria>  {




}
