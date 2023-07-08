package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.EtatRendezVousCriteria;
import ma.sir.vaccination.bean.core.EtatRendezVous;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EtatRendezVousSpecification extends  AbstractSpecification<EtatRendezVousCriteria, EtatRendezVous>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatRendezVousSpecification(EtatRendezVousCriteria criteria) {
        super(criteria);
    }

    public EtatRendezVousSpecification(EtatRendezVousCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
