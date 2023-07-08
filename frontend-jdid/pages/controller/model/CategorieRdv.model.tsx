import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";

export class CategorieRdvDto extends BaseDto{


    public id: number;
    public code: string;
    public libelle: string;
   public nombreDose: number;
   public dureeDose: number;
    public nombreDoseMax: string ;
    public nombreDoseMin: string ;
    public dureeDoseMax: string ;
    public dureeDoseMin: string ;

}
