package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.EffetIndesirable;
import ma.sir.vaccination.bean.history.EffetIndesirableHistory;
import ma.sir.vaccination.dao.criteria.core.EffetIndesirableCriteria;
import ma.sir.vaccination.dao.criteria.history.EffetIndesirableHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.EffetIndesirableDao;
import ma.sir.vaccination.dao.facade.history.EffetIndesirableHistoryDao;
import ma.sir.vaccination.dao.specification.core.EffetIndesirableSpecification;
import ma.sir.vaccination.service.facade.admin.EffetIndesirableAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import ma.sir.vaccination.zynerator.util.VelocityPdf;
import ma.sir.vaccination.ws.dto.EffetIndesirableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.vaccination.service.facade.admin.RendezVousAdminService ;



import java.util.List;
@Service
public class EffetIndesirableAdminServiceImpl extends AbstractServiceImpl<EffetIndesirable,EffetIndesirableHistory, EffetIndesirableCriteria, EffetIndesirableHistoryCriteria, EffetIndesirableDao,
EffetIndesirableHistoryDao> implements EffetIndesirableAdminService {
    public static final String TEMPLATE = "template/effetIndesirable.vm";
    public static final String FILE_NAME = "effetIndesirable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EffetIndesirableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<EffetIndesirable> findByRendezVousId(Long id){
        return dao.findByRendezVousId(id);
    }
    public int deleteByRendezVousId(Long id){
        return dao.deleteByRendezVousId(id);
    }




    public void configure() {
        super.configure(EffetIndesirable.class,EffetIndesirableHistory.class, EffetIndesirableHistoryCriteria.class, EffetIndesirableSpecification.class);
    }

    @Autowired
    private RendezVousAdminService rendezVousService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public EffetIndesirableAdminServiceImpl(EffetIndesirableDao dao, EffetIndesirableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}