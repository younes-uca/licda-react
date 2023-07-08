package  ma.sir.vaccination.dao.specification.core;

import ma.sir.vaccination.zynerator.specification.AbstractSpecification;
import ma.sir.vaccination.dao.criteria.core.DoseCriteria;
import ma.sir.vaccination.bean.core.Dose;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DoseSpecification extends  AbstractSpecification<DoseCriteria, Dose>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebutPrevu", criteria.getDateDebutPrevu(), criteria.getDateDebutPrevuFrom(), criteria.getDateDebutPrevuTo());
        addPredicate("dateDebutEffectif", criteria.getDateDebutEffectif(), criteria.getDateDebutEffectifFrom(), criteria.getDateDebutEffectifTo());
        addPredicateFk("rendezVous","id", criteria.getRendezVous()==null?null:criteria.getRendezVous().getId());
        addPredicateFk("rendezVous","id", criteria.getRendezVouss());
        addPredicateFk("etatDose","id", criteria.getEtatDose()==null?null:criteria.getEtatDose().getId());
        addPredicateFk("etatDose","id", criteria.getEtatDoses());
        addPredicateFk("etatDose","code", criteria.getEtatDose()==null?null:criteria.getEtatDose().getCode());
    }

    public DoseSpecification(DoseCriteria criteria) {
        super(criteria);
    }

    public DoseSpecification(DoseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
