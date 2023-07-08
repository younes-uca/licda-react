package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Dose;
import ma.sir.vaccination.bean.history.DoseHistory;
import ma.sir.vaccination.dao.criteria.core.DoseCriteria;
import ma.sir.vaccination.dao.criteria.history.DoseHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.DoseDao;
import ma.sir.vaccination.dao.facade.history.DoseHistoryDao;
import ma.sir.vaccination.dao.specification.core.DoseSpecification;
import ma.sir.vaccination.service.facade.admin.DoseAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import ma.sir.vaccination.zynerator.util.VelocityPdf;
import ma.sir.vaccination.ws.dto.DoseDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.vaccination.service.facade.admin.EtatDoseAdminService ;
import ma.sir.vaccination.service.facade.admin.RendezVousAdminService ;



import java.util.List;
@Service
public class DoseAdminServiceImpl extends AbstractServiceImpl<Dose,DoseHistory, DoseCriteria, DoseHistoryCriteria, DoseDao,
DoseHistoryDao> implements DoseAdminService {
    public static final String TEMPLATE = "template/dose.vm";
    public static final String FILE_NAME = "dose.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DoseDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<Dose> findByRendezVousId(Long id){
        return dao.findByRendezVousId(id);
    }
    public int deleteByRendezVousId(Long id){
        return dao.deleteByRendezVousId(id);
    }
    public List<Dose> findByEtatDoseId(Long id){
        return dao.findByEtatDoseId(id);
    }
    public int deleteByEtatDoseId(Long id){
        return dao.deleteByEtatDoseId(id);
    }




    public void configure() {
        super.configure(Dose.class,DoseHistory.class, DoseHistoryCriteria.class, DoseSpecification.class);
    }

    @Autowired
    private EtatDoseAdminService etatDoseService ;
    @Autowired
    private RendezVousAdminService rendezVousService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DoseAdminServiceImpl(DoseDao dao, DoseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}