package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.EffetIndesirableHistoryCriteria;
import ma.sir.vaccination.bean.history.EffetIndesirableHistory;


public class EffetIndesirableHistorySpecification extends AbstractHistorySpecification<EffetIndesirableHistoryCriteria, EffetIndesirableHistory> {

    public EffetIndesirableHistorySpecification(EffetIndesirableHistoryCriteria criteria) {
        super(criteria);
    }

    public EffetIndesirableHistorySpecification(EffetIndesirableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
