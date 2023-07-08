package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.MedecinHistoryCriteria;
import ma.sir.vaccination.bean.history.MedecinHistory;


public class MedecinHistorySpecification extends AbstractHistorySpecification<MedecinHistoryCriteria, MedecinHistory> {

    public MedecinHistorySpecification(MedecinHistoryCriteria criteria) {
        super(criteria);
    }

    public MedecinHistorySpecification(MedecinHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
