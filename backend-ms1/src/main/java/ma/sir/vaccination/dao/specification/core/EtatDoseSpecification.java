package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.EtatDoseCriteria;
import ma.sir.vaccination.bean.core.EtatDose;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EtatDoseSpecification extends  AbstractSpecification<EtatDoseCriteria, EtatDose>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatDoseSpecification(EtatDoseCriteria criteria) {
        super(criteria);
    }

    public EtatDoseSpecification(EtatDoseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
