package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.VilleCriteria;
import ma.sir.vaccination.bean.core.Ville;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VilleSpecification extends  AbstractSpecification<VilleCriteria, Ville>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public VilleSpecification(VilleCriteria criteria) {
        super(criteria);
    }

    public VilleSpecification(VilleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
