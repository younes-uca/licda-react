package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.CategorieRdv;
import ma.sir.vaccination.bean.history.CategorieRdvHistory;
import ma.sir.vaccination.dao.criteria.core.CategorieRdvCriteria;
import ma.sir.vaccination.dao.criteria.history.CategorieRdvHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.CategorieRdvDao;
import ma.sir.vaccination.dao.facade.history.CategorieRdvHistoryDao;
import ma.sir.vaccination.dao.specification.core.CategorieRdvSpecification;
import ma.sir.vaccination.service.facade.admin.CategorieRdvAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class CategorieRdvAdminServiceImpl extends AbstractServiceImpl<CategorieRdv,CategorieRdvHistory, CategorieRdvCriteria, CategorieRdvHistoryCriteria, CategorieRdvDao,
CategorieRdvHistoryDao> implements CategorieRdvAdminService {



    public CategorieRdv findByReferenceEntity(CategorieRdv t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(CategorieRdv.class,CategorieRdvHistory.class, CategorieRdvHistoryCriteria.class, CategorieRdvSpecification.class);
    }


    public CategorieRdvAdminServiceImpl(CategorieRdvDao dao, CategorieRdvHistoryDao historyDao) {
        super(dao, historyDao);
    }

}