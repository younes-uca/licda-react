package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Patient;
import ma.sir.vaccination.bean.history.PatientHistory;
import ma.sir.vaccination.dao.criteria.core.PatientCriteria;
import ma.sir.vaccination.dao.criteria.history.PatientHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.PatientDao;
import ma.sir.vaccination.dao.facade.history.PatientHistoryDao;
import ma.sir.vaccination.dao.specification.core.PatientSpecification;
import ma.sir.vaccination.service.facade.admin.PatientAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import ma.sir.vaccination.zynerator.util.VelocityPdf;
import ma.sir.vaccination.ws.dto.PatientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.vaccination.service.facade.admin.VilleAdminService ;
import ma.sir.vaccination.service.facade.admin.GenderAdminService ;



import java.util.List;
@Service
public class PatientAdminServiceImpl extends AbstractServiceImpl<Patient,PatientHistory, PatientCriteria, PatientHistoryCriteria, PatientDao,
PatientHistoryDao> implements PatientAdminService {
    public static final String TEMPLATE = "template/patient.vm";
    public static final String FILE_NAME = "patient.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PatientDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Patient findByReferenceEntity(Patient t){
        return  dao.findByIpp(t.getIpp());
    }

    public List<Patient> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }
    public List<Patient> findByGenderId(Long id){
        return dao.findByGenderId(id);
    }
    public int deleteByGenderId(Long id){
        return dao.deleteByGenderId(id);
    }




    public void configure() {
        super.configure(Patient.class,PatientHistory.class, PatientHistoryCriteria.class, PatientSpecification.class);
    }

    @Autowired
    private VilleAdminService villeService ;
    @Autowired
    private GenderAdminService genderService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PatientAdminServiceImpl(PatientDao dao, PatientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}