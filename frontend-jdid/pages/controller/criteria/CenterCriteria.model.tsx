import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {QuartierCriteria} from 'QuartierCriteria.model';




export class CenterCriteria  extends  BaseCriteria {


    public id: number;

    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public quartier: QuartierCriteria ;
  public quartiers: Array<QuartierCriteria> ;


}
