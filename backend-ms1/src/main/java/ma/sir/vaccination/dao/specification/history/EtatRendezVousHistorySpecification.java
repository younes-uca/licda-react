package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.EtatRendezVousHistoryCriteria;
import ma.sir.vaccination.bean.history.EtatRendezVousHistory;


public class EtatRendezVousHistorySpecification extends AbstractHistorySpecification<EtatRendezVousHistoryCriteria, EtatRendezVousHistory> {

    public EtatRendezVousHistorySpecification(EtatRendezVousHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatRendezVousHistorySpecification(EtatRendezVousHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
