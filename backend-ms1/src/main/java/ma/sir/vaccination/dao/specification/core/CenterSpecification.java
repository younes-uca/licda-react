package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.CenterCriteria;
import ma.sir.vaccination.bean.core.Center;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CenterSpecification extends  AbstractSpecification<CenterCriteria, Center>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("quartier","id", criteria.getQuartier()==null?null:criteria.getQuartier().getId());
        addPredicateFk("quartier","id", criteria.getQuartiers());
        addPredicateFk("quartier","code", criteria.getQuartier()==null?null:criteria.getQuartier().getCode());
    }

    public CenterSpecification(CenterCriteria criteria) {
        super(criteria);
    }

    public CenterSpecification(CenterCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
