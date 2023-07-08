package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.GenderHistoryCriteria;
import ma.sir.vaccination.bean.history.GenderHistory;


public class GenderHistorySpecification extends AbstractHistorySpecification<GenderHistoryCriteria, GenderHistory> {

    public GenderHistorySpecification(GenderHistoryCriteria criteria) {
        super(criteria);
    }

    public GenderHistorySpecification(GenderHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
