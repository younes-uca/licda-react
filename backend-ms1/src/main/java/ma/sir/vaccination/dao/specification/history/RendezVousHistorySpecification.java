package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.RendezVousHistoryCriteria;
import ma.sir.vaccination.bean.history.RendezVousHistory;


public class RendezVousHistorySpecification extends AbstractHistorySpecification<RendezVousHistoryCriteria, RendezVousHistory> {

    public RendezVousHistorySpecification(RendezVousHistoryCriteria criteria) {
        super(criteria);
    }

    public RendezVousHistorySpecification(RendezVousHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
