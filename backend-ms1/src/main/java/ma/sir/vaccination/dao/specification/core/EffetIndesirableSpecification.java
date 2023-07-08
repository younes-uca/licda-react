package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.EffetIndesirableCriteria;
import ma.sir.vaccination.bean.core.EffetIndesirable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EffetIndesirableSpecification extends  AbstractSpecification<EffetIndesirableCriteria, EffetIndesirable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateFait", criteria.getDateFait(), criteria.getDateFaitFrom(), criteria.getDateFaitTo());
        addPredicateFk("rendezVous","id", criteria.getRendezVous()==null?null:criteria.getRendezVous().getId());
        addPredicateFk("rendezVous","id", criteria.getRendezVouss());
    }

    public EffetIndesirableSpecification(EffetIndesirableCriteria criteria) {
        super(criteria);
    }

    public EffetIndesirableSpecification(EffetIndesirableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
