package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.PatientHistoryCriteria;
import ma.sir.vaccination.bean.history.PatientHistory;


public class PatientHistorySpecification extends AbstractHistorySpecification<PatientHistoryCriteria, PatientHistory> {

    public PatientHistorySpecification(PatientHistoryCriteria criteria) {
        super(criteria);
    }

    public PatientHistorySpecification(PatientHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
