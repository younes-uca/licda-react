package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.RendezVousCriteria;
import ma.sir.vaccination.bean.core.RendezVous;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RendezVousSpecification extends  AbstractSpecification<RendezVousCriteria, RendezVous>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("datePriseRdv", criteria.getDatePriseRdv(), criteria.getDatePriseRdvFrom(), criteria.getDatePriseRdvTo());
        addPredicateFk("patient","id", criteria.getPatient()==null?null:criteria.getPatient().getId());
        addPredicateFk("patient","id", criteria.getPatients());
        addPredicateFk("patient","ipp", criteria.getPatient()==null?null:criteria.getPatient().getIpp());
        addPredicateFk("center","id", criteria.getCenter()==null?null:criteria.getCenter().getId());
        addPredicateFk("center","id", criteria.getCenters());
        addPredicateFk("center","code", criteria.getCenter()==null?null:criteria.getCenter().getCode());
        addPredicateFk("medecin","id", criteria.getMedecin()==null?null:criteria.getMedecin().getId());
        addPredicateFk("medecin","id", criteria.getMedecins());
        addPredicateFk("categorieRdv","id", criteria.getCategorieRdv()==null?null:criteria.getCategorieRdv().getId());
        addPredicateFk("categorieRdv","id", criteria.getCategorieRdvs());
        addPredicateFk("categorieRdv","code", criteria.getCategorieRdv()==null?null:criteria.getCategorieRdv().getCode());
        addPredicateFk("etatRendezVous","id", criteria.getEtatRendezVous()==null?null:criteria.getEtatRendezVous().getId());
        addPredicateFk("etatRendezVous","id", criteria.getEtatRendezVouss());
        addPredicateFk("etatRendezVous","code", criteria.getEtatRendezVous()==null?null:criteria.getEtatRendezVous().getCode());
    }

    public RendezVousSpecification(RendezVousCriteria criteria) {
        super(criteria);
    }

    public RendezVousSpecification(RendezVousCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
