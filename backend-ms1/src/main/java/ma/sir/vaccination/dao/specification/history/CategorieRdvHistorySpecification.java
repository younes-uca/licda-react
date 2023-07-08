package  ma.sir.vaccination.dao.specification.history;

import ma.sir.vaccination.zynerator.specification.AbstractHistorySpecification;
import ma.sir.vaccination.dao.criteria.history.CategorieRdvHistoryCriteria;
import ma.sir.vaccination.bean.history.CategorieRdvHistory;


public class CategorieRdvHistorySpecification extends AbstractHistorySpecification<CategorieRdvHistoryCriteria, CategorieRdvHistory> {

    public CategorieRdvHistorySpecification(CategorieRdvHistoryCriteria criteria) {
        super(criteria);
    }

    public CategorieRdvHistorySpecification(CategorieRdvHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
