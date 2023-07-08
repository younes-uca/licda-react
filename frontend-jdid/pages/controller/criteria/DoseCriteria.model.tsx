import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {EtatDoseCriteria} from 'EtatDoseCriteria.model';
import {RendezVousCriteria} from 'RendezVousCriteria.model';




export class DoseCriteria  extends  BaseCriteria {


    public id: number;

    public dateDebutPrevu: Date;
    public dateDebutPrevuFrom: Date;
    public dateDebutPrevuTo: Date;
    public dateDebutEffectif: Date;
    public dateDebutEffectifFrom: Date;
    public dateDebutEffectifTo: Date;
    public description: string;
    public descriptionLike: string;
  public rendezVous: RendezVousCriteria ;
  public rendezVouss: Array<RendezVousCriteria> ;
  public etatDose: EtatDoseCriteria ;
  public etatDoses: Array<EtatDoseCriteria> ;


}
