import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';





export class CategorieRdvCriteria  extends  BaseCriteria {


    public id: number;

    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
     public nombreDose: number;
     public nombreDoseMin: number;
     public nombreDoseMax: number;
     public dureeDose: number;
     public dureeDoseMin: number;
     public dureeDoseMax: number;


}
