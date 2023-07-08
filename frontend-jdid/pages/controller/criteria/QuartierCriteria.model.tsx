import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {VilleCriteria} from 'VilleCriteria.model';




export class QuartierCriteria  extends  BaseCriteria {


    public id: number;

    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public ville: VilleCriteria ;
  public villes: Array<VilleCriteria> ;


}
