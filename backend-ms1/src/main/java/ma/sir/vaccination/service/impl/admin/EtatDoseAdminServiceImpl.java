package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.EtatDose;
import ma.sir.vaccination.bean.history.EtatDoseHistory;
import ma.sir.vaccination.dao.criteria.core.EtatDoseCriteria;
import ma.sir.vaccination.dao.criteria.history.EtatDoseHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.EtatDoseDao;
import ma.sir.vaccination.dao.facade.history.EtatDoseHistoryDao;
import ma.sir.vaccination.dao.specification.core.EtatDoseSpecification;
import ma.sir.vaccination.service.facade.admin.EtatDoseAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class EtatDoseAdminServiceImpl extends AbstractServiceImpl<EtatDose,EtatDoseHistory, EtatDoseCriteria, EtatDoseHistoryCriteria, EtatDoseDao,
EtatDoseHistoryDao> implements EtatDoseAdminService {



    public EtatDose findByReferenceEntity(EtatDose t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(EtatDose.class,EtatDoseHistory.class, EtatDoseHistoryCriteria.class, EtatDoseSpecification.class);
    }


    public EtatDoseAdminServiceImpl(EtatDoseDao dao, EtatDoseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}