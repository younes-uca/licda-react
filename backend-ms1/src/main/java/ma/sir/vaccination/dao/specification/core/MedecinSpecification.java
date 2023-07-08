package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.MedecinCriteria;
import ma.sir.vaccination.bean.core.Medecin;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MedecinSpecification extends  AbstractSpecification<MedecinCriteria, Medecin>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicateFk("center","id", criteria.getCenter()==null?null:criteria.getCenter().getId());
        addPredicateFk("center","id", criteria.getCenters());
        addPredicateFk("center","code", criteria.getCenter()==null?null:criteria.getCenter().getCode());
    }

    public MedecinSpecification(MedecinCriteria criteria) {
        super(criteria);
    }

    public MedecinSpecification(MedecinCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
