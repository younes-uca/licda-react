package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.DoseHistoryCriteria;
import ma.sir.vaccination.bean.history.DoseHistory;


public class DoseHistorySpecification extends AbstractHistorySpecification<DoseHistoryCriteria, DoseHistory> {

    public DoseHistorySpecification(DoseHistoryCriteria criteria) {
        super(criteria);
    }

    public DoseHistorySpecification(DoseHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
