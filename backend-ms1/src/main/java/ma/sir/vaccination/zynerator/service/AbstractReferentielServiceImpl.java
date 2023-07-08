package ma.sir.vaccination.zynerator.service;

import ma.sir.vaccination.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import ma.sir.vaccination.zynerator.history.HistCriteria;
import ma.sir.vaccination.zynerator.repository.AbstractHistoryRepository;
import ma.sir.vaccination.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}