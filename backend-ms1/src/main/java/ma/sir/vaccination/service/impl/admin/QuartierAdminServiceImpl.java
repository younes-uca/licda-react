package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Quartier;
import ma.sir.vaccination.bean.history.QuartierHistory;
import ma.sir.vaccination.dao.criteria.core.QuartierCriteria;
import ma.sir.vaccination.dao.criteria.history.QuartierHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.QuartierDao;
import ma.sir.vaccination.dao.facade.history.QuartierHistoryDao;
import ma.sir.vaccination.dao.specification.core.QuartierSpecification;
import ma.sir.vaccination.service.facade.admin.QuartierAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.vaccination.service.facade.admin.VilleAdminService ;



import java.util.List;
@Service
public class QuartierAdminServiceImpl extends AbstractServiceImpl<Quartier,QuartierHistory, QuartierCriteria, QuartierHistoryCriteria, QuartierDao,
QuartierHistoryDao> implements QuartierAdminService {



    public Quartier findByReferenceEntity(Quartier t){
        return  dao.findByCode(t.getCode());
    }

    public List<Quartier> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }




    public void configure() {
        super.configure(Quartier.class,QuartierHistory.class, QuartierHistoryCriteria.class, QuartierSpecification.class);
    }

    @Autowired
    private VilleAdminService villeService ;

    public QuartierAdminServiceImpl(QuartierDao dao, QuartierHistoryDao historyDao) {
        super(dao, historyDao);
    }

}