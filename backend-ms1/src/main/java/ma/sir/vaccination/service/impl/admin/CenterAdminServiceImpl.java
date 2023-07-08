package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Center;
import ma.sir.vaccination.bean.history.CenterHistory;
import ma.sir.vaccination.dao.criteria.core.CenterCriteria;
import ma.sir.vaccination.dao.criteria.history.CenterHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.CenterDao;
import ma.sir.vaccination.dao.facade.history.CenterHistoryDao;
import ma.sir.vaccination.dao.specification.core.CenterSpecification;
import ma.sir.vaccination.service.facade.admin.CenterAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.vaccination.service.facade.admin.QuartierAdminService ;



import java.util.List;
@Service
public class CenterAdminServiceImpl extends AbstractServiceImpl<Center,CenterHistory, CenterCriteria, CenterHistoryCriteria, CenterDao,
CenterHistoryDao> implements CenterAdminService {



    public Center findByReferenceEntity(Center t){
        return  dao.findByCode(t.getCode());
    }

    public List<Center> findByQuartierId(Long id){
        return dao.findByQuartierId(id);
    }
    public int deleteByQuartierId(Long id){
        return dao.deleteByQuartierId(id);
    }




    public void configure() {
        super.configure(Center.class,CenterHistory.class, CenterHistoryCriteria.class, CenterSpecification.class);
    }

    @Autowired
    private QuartierAdminService quartierService ;

    public CenterAdminServiceImpl(CenterDao dao, CenterHistoryDao historyDao) {
        super(dao, historyDao);
    }

}