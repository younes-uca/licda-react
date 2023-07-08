package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.EtatRendezVous;
import ma.sir.vaccination.bean.history.EtatRendezVousHistory;
import ma.sir.vaccination.dao.criteria.core.EtatRendezVousCriteria;
import ma.sir.vaccination.dao.criteria.history.EtatRendezVousHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.EtatRendezVousDao;
import ma.sir.vaccination.dao.facade.history.EtatRendezVousHistoryDao;
import ma.sir.vaccination.dao.specification.core.EtatRendezVousSpecification;
import ma.sir.vaccination.service.facade.admin.EtatRendezVousAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class EtatRendezVousAdminServiceImpl extends AbstractServiceImpl<EtatRendezVous,EtatRendezVousHistory, EtatRendezVousCriteria, EtatRendezVousHistoryCriteria, EtatRendezVousDao,
EtatRendezVousHistoryDao> implements EtatRendezVousAdminService {



    public EtatRendezVous findByReferenceEntity(EtatRendezVous t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(EtatRendezVous.class,EtatRendezVousHistory.class, EtatRendezVousHistoryCriteria.class, EtatRendezVousSpecification.class);
    }


    public EtatRendezVousAdminServiceImpl(EtatRendezVousDao dao, EtatRendezVousHistoryDao historyDao) {
        super(dao, historyDao);
    }

}