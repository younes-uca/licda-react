import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {RendezVousCriteria} from 'RendezVousCriteria.model';




export class EffetIndesirableCriteria  extends  BaseCriteria {


    public id: number;

    public dateFait: Date;
    public dateFaitFrom: Date;
    public dateFaitTo: Date;
    public description: string;
    public descriptionLike: string;
  public rendezVous: RendezVousCriteria ;
  public rendezVouss: Array<RendezVousCriteria> ;


}
