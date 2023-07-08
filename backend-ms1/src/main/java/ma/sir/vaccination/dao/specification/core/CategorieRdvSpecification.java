package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.CategorieRdvCriteria;
import ma.sir.vaccination.bean.core.CategorieRdv;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CategorieRdvSpecification extends  AbstractSpecification<CategorieRdvCriteria, CategorieRdv>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateInt("nombreDose", criteria.getNombreDose(), criteria.getNombreDoseMin(), criteria.getNombreDoseMax());
        addPredicateInt("dureeDose", criteria.getDureeDose(), criteria.getDureeDoseMin(), criteria.getDureeDoseMax());
    }

    public CategorieRdvSpecification(CategorieRdvCriteria criteria) {
        super(criteria);
    }

    public CategorieRdvSpecification(CategorieRdvCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
