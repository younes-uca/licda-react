package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.RendezVous;
import ma.sir.vaccination.bean.history.RendezVousHistory;
import ma.sir.vaccination.dao.criteria.core.RendezVousCriteria;
import ma.sir.vaccination.dao.criteria.history.RendezVousHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.RendezVousDao;
import ma.sir.vaccination.dao.facade.history.RendezVousHistoryDao;
import ma.sir.vaccination.dao.specification.core.RendezVousSpecification;
import ma.sir.vaccination.service.facade.admin.RendezVousAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import ma.sir.vaccination.zynerator.util.VelocityPdf;
import ma.sir.vaccination.ws.dto.RendezVousDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.vaccination.bean.core.Dose;
import ma.sir.vaccination.bean.core.EffetIndesirable;

import ma.sir.vaccination.service.facade.admin.CategorieRdvAdminService ;
import ma.sir.vaccination.service.facade.admin.EtatRendezVousAdminService ;
import ma.sir.vaccination.service.facade.admin.MedecinAdminService ;
import ma.sir.vaccination.service.facade.admin.DoseAdminService ;
import ma.sir.vaccination.service.facade.admin.CenterAdminService ;
import ma.sir.vaccination.service.facade.admin.EffetIndesirableAdminService ;
import ma.sir.vaccination.service.facade.admin.PatientAdminService ;



import java.util.List;
@Service
public class RendezVousAdminServiceImpl extends AbstractServiceImpl<RendezVous,RendezVousHistory, RendezVousCriteria, RendezVousHistoryCriteria, RendezVousDao,
RendezVousHistoryDao> implements RendezVousAdminService {
    public static final String TEMPLATE = "template/rendezVous.vm";
    public static final String FILE_NAME = "rendezVous.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(RendezVousDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public RendezVous create(RendezVous t) {
        super.create(t);
        if (t.getDoses() != null) {
                t.getDoses().forEach(element-> {
                    element.setRendezVous(t);
                    doseService.create(element);
            });
        }
        if (t.getEffetIndesirables() != null) {
                t.getEffetIndesirables().forEach(element-> {
                    element.setRendezVous(t);
                    effetIndesirableService.create(element);
            });
        }
        return t;
    }

    public RendezVous findWithAssociatedLists(Long id){
        RendezVous result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDoses(doseService.findByRendezVousId(id));
            result.setEffetIndesirables(effetIndesirableService.findByRendezVousId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        doseService.deleteByRendezVousId(id);
        effetIndesirableService.deleteByRendezVousId(id);
    }


    public void updateWithAssociatedLists(RendezVous rendezVous){
    if(rendezVous !=null && rendezVous.getId() != null){
            List<List<Dose>> resultDoses= doseService.getToBeSavedAndToBeDeleted(doseService.findByRendezVousId(rendezVous.getId()),rendezVous.getDoses());
            doseService.delete(resultDoses.get(1));
            ListUtil.emptyIfNull(resultDoses.get(0)).forEach(e -> e.setRendezVous(rendezVous));
            doseService.update(resultDoses.get(0),true);
            List<List<EffetIndesirable>> resultEffetIndesirables= effetIndesirableService.getToBeSavedAndToBeDeleted(effetIndesirableService.findByRendezVousId(rendezVous.getId()),rendezVous.getEffetIndesirables());
            effetIndesirableService.delete(resultEffetIndesirables.get(1));
            ListUtil.emptyIfNull(resultEffetIndesirables.get(0)).forEach(e -> e.setRendezVous(rendezVous));
            effetIndesirableService.update(resultEffetIndesirables.get(0),true);
    }
    }


    public List<RendezVous> findByPatientId(Long id){
        return dao.findByPatientId(id);
    }
    public int deleteByPatientId(Long id){
        return dao.deleteByPatientId(id);
    }
    public List<RendezVous> findByCenterId(Long id){
        return dao.findByCenterId(id);
    }
    public int deleteByCenterId(Long id){
        return dao.deleteByCenterId(id);
    }
    public List<RendezVous> findByMedecinId(Long id){
        return dao.findByMedecinId(id);
    }
    public int deleteByMedecinId(Long id){
        return dao.deleteByMedecinId(id);
    }
    public List<RendezVous> findByCategorieRdvId(Long id){
        return dao.findByCategorieRdvId(id);
    }
    public int deleteByCategorieRdvId(Long id){
        return dao.deleteByCategorieRdvId(id);
    }
    public List<RendezVous> findByEtatRendezVousId(Long id){
        return dao.findByEtatRendezVousId(id);
    }
    public int deleteByEtatRendezVousId(Long id){
        return dao.deleteByEtatRendezVousId(id);
    }




    public void configure() {
        super.configure(RendezVous.class,RendezVousHistory.class, RendezVousHistoryCriteria.class, RendezVousSpecification.class);
    }

    @Autowired
    private CategorieRdvAdminService categorieRdvService ;
    @Autowired
    private EtatRendezVousAdminService etatRendezVousService ;
    @Autowired
    private MedecinAdminService medecinService ;
    @Autowired
    private DoseAdminService doseService ;
    @Autowired
    private CenterAdminService centerService ;
    @Autowired
    private EffetIndesirableAdminService effetIndesirableService ;
    @Autowired
    private PatientAdminService patientService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public RendezVousAdminServiceImpl(RendezVousDao dao, RendezVousHistoryDao historyDao) {
        super(dao, historyDao);
    }

}