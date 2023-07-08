package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.QuartierHistoryCriteria;
import ma.sir.vaccination.bean.history.QuartierHistory;


public class QuartierHistorySpecification extends AbstractHistorySpecification<QuartierHistoryCriteria, QuartierHistory> {

    public QuartierHistorySpecification(QuartierHistoryCriteria criteria) {
        super(criteria);
    }

    public QuartierHistorySpecification(QuartierHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
