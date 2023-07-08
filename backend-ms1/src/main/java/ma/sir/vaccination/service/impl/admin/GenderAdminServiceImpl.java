package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Gender;
import ma.sir.vaccination.bean.history.GenderHistory;
import ma.sir.vaccination.dao.criteria.core.GenderCriteria;
import ma.sir.vaccination.dao.criteria.history.GenderHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.GenderDao;
import ma.sir.vaccination.dao.facade.history.GenderHistoryDao;
import ma.sir.vaccination.dao.specification.core.GenderSpecification;
import ma.sir.vaccination.service.facade.admin.GenderAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class GenderAdminServiceImpl extends AbstractServiceImpl<Gender,GenderHistory, GenderCriteria, GenderHistoryCriteria, GenderDao,
GenderHistoryDao> implements GenderAdminService {



    public Gender findByReferenceEntity(Gender t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Gender.class,GenderHistory.class, GenderHistoryCriteria.class, GenderSpecification.class);
    }


    public GenderAdminServiceImpl(GenderDao dao, GenderHistoryDao historyDao) {
        super(dao, historyDao);
    }

}