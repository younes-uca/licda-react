package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Ville;
import ma.sir.vaccination.bean.history.VilleHistory;
import ma.sir.vaccination.dao.criteria.core.VilleCriteria;
import ma.sir.vaccination.dao.criteria.history.VilleHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.VilleDao;
import ma.sir.vaccination.dao.facade.history.VilleHistoryDao;
import ma.sir.vaccination.dao.specification.core.VilleSpecification;
import ma.sir.vaccination.service.facade.admin.VilleAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class VilleAdminServiceImpl extends AbstractServiceImpl<Ville,VilleHistory, VilleCriteria, VilleHistoryCriteria, VilleDao,
VilleHistoryDao> implements VilleAdminService {



    public Ville findByReferenceEntity(Ville t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Ville.class,VilleHistory.class, VilleHistoryCriteria.class, VilleSpecification.class);
    }


    public VilleAdminServiceImpl(VilleDao dao, VilleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}