package ma.sir.vaccination.service.facade.admin;

import java.util.List;
import ma.sir.vaccination.bean.core.EtatRendezVous;
import ma.sir.vaccination.dao.criteria.core.EtatRendezVousCriteria;
import ma.sir.vaccination.dao.criteria.history.EtatRendezVousHistoryCriteria;
import ma.sir.vaccination.zynerator.service.IService;


public interface EtatRendezVousAdminService extends  IService<EtatRendezVous,EtatRendezVousCriteria, EtatRendezVousHistoryCriteria>  {




}
