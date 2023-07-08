package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.CenterHistoryCriteria;
import ma.sir.vaccination.bean.history.CenterHistory;


public class CenterHistorySpecification extends AbstractHistorySpecification<CenterHistoryCriteria, CenterHistory> {

    public CenterHistorySpecification(CenterHistoryCriteria criteria) {
        super(criteria);
    }

    public CenterHistorySpecification(CenterHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
