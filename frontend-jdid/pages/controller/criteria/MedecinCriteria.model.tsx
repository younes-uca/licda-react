import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {CenterCriteria} from 'CenterCriteria.model';




export class MedecinCriteria  extends  BaseCriteria {


    public id: number;

    public email: string;
    public emailLike: string;
    public cin: string;
    public cinLike: string;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
  public center: CenterCriteria ;
  public centers: Array<CenterCriteria> ;


}
