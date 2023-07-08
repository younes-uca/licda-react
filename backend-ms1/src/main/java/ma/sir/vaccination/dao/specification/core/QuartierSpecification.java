package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.QuartierCriteria;
import ma.sir.vaccination.bean.core.Quartier;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class QuartierSpecification extends  AbstractSpecification<QuartierCriteria, Quartier>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("ville","id", criteria.getVille()==null?null:criteria.getVille().getId());
        addPredicateFk("ville","id", criteria.getVilles());
        addPredicateFk("ville","code", criteria.getVille()==null?null:criteria.getVille().getCode());
    }

    public QuartierSpecification(QuartierCriteria criteria) {
        super(criteria);
    }

    public QuartierSpecification(QuartierCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
