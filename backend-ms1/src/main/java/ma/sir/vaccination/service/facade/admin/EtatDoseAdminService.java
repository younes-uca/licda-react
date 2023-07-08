package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.EtatDose;
import ma.sir.vaccination.dao.criteria.core.EtatDoseCriteria;
import ma.sir.vaccination.dao.criteria.history.EtatDoseHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface EtatDoseAdminService extends  IService<EtatDose,EtatDoseCriteria, EtatDoseHistoryCriteria>  {




}
