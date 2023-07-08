package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.EtatDoseHistoryCriteria;
import ma.sir.vaccination.bean.history.EtatDoseHistory;


public class EtatDoseHistorySpecification extends AbstractHistorySpecification<EtatDoseHistoryCriteria, EtatDoseHistory> {

    public EtatDoseHistorySpecification(EtatDoseHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatDoseHistorySpecification(EtatDoseHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
