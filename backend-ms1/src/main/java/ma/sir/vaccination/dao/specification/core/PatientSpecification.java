package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.PatientCriteria;
import ma.sir.vaccination.bean.core.Patient;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PatientSpecification extends  AbstractSpecification<PatientCriteria, Patient>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ipp", criteria.getIpp(),criteria.getIppLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicateInt("age", criteria.getAge(), criteria.getAgeMin(), criteria.getAgeMax());
        addPredicateFk("ville","id", criteria.getVille()==null?null:criteria.getVille().getId());
        addPredicateFk("ville","id", criteria.getVilles());
        addPredicateFk("ville","code", criteria.getVille()==null?null:criteria.getVille().getCode());
        addPredicateFk("gender","id", criteria.getGender()==null?null:criteria.getGender().getId());
        addPredicateFk("gender","id", criteria.getGenders());
        addPredicateFk("gender","code", criteria.getGender()==null?null:criteria.getGender().getCode());
    }

    public PatientSpecification(PatientCriteria criteria) {
        super(criteria);
    }

    public PatientSpecification(PatientCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
