package ma.sir.vaccination.service.impl.admin;

import ma.sir.vaccination.bean.core.Medecin;
import ma.sir.vaccination.bean.history.MedecinHistory;
import ma.sir.vaccination.dao.criteria.core.MedecinCriteria;
import ma.sir.vaccination.dao.criteria.history.MedecinHistoryCriteria;
import ma.sir.vaccination.dao.facade.core.MedecinDao;
import ma.sir.vaccination.dao.facade.history.MedecinHistoryDao;
import ma.sir.vaccination.dao.specification.core.MedecinSpecification;
import ma.sir.vaccination.service.facade.admin.MedecinAdminService;
import ma.sir.vaccination.zynerator.service.AbstractServiceImpl;
import ma.sir.vaccination.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import ma.sir.vaccination.zynerator.util.VelocityPdf;
import ma.sir.vaccination.ws.dto.MedecinDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.vaccination.service.facade.admin.CenterAdminService ;



import java.util.List;
@Service
public class MedecinAdminServiceImpl extends AbstractServiceImpl<Medecin,MedecinHistory, MedecinCriteria, MedecinHistoryCriteria, MedecinDao,
MedecinHistoryDao> implements MedecinAdminService {
    public static final String TEMPLATE = "template/medecin.vm";
    public static final String FILE_NAME = "medecin.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(MedecinDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<Medecin> findByCenterId(Long id){
        return dao.findByCenterId(id);
    }
    public int deleteByCenterId(Long id){
        return dao.deleteByCenterId(id);
    }




    public void configure() {
        super.configure(Medecin.class,MedecinHistory.class, MedecinHistoryCriteria.class, MedecinSpecification.class);
    }

    @Autowired
    private CenterAdminService centerService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public MedecinAdminServiceImpl(MedecinDao dao, MedecinHistoryDao historyDao) {
        super(dao, historyDao);
    }

}