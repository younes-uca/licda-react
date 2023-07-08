import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {EtatDoseDto} from 'pages/controller/model/EtatDose.model';
import {RendezVousDto} from 'pages/controller/model/RendezVous.model';

export class DoseDto extends BaseDto{


    public id: number;
   public dateDebutPrevu: Date;
   public dateDebutEffectif: Date;
    public description: string;
    public dateDebutPrevuMax: string ;
    public dateDebutPrevuMin: string ;
    public dateDebutEffectifMax: string ;
    public dateDebutEffectifMin: string ;
    public rendezVous: RendezVousDto ;
    public etatDose: EtatDoseDto ;

}
