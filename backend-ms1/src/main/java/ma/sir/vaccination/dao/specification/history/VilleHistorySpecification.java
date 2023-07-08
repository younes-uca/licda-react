package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.VilleHistoryCriteria;
import ma.sir.vaccination.bean.history.VilleHistory;


public class VilleHistorySpecification extends AbstractHistorySpecification<VilleHistoryCriteria, VilleHistory> {

    public VilleHistorySpecification(VilleHistoryCriteria criteria) {
        super(criteria);
    }

    public VilleHistorySpecification(VilleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
