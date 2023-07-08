import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {EtatRendezVousDto} from 'pages/controller/model/EtatRendezVous.model';
import {CenterDto} from 'pages/controller/model/Center.model';
import {CategorieRdvDto} from 'pages/controller/model/CategorieRdv.model';
import {MedecinDto} from 'pages/controller/model/Medecin.model';
import {PatientDto} from 'pages/controller/model/Patient.model';
import {EffetIndesirableDto} from 'pages/controller/model/EffetIndesirable.model';
import {DoseDto} from 'pages/controller/model/Dose.model';

export class RendezVousDto extends BaseDto{


    public id: number;
   public datePriseRdv: Date;
    public datePriseRdvMax: string ;
    public datePriseRdvMin: string ;
    public patient: PatientDto ;
    public center: CenterDto ;
    public medecin: MedecinDto ;
    public categorieRdv: CategorieRdvDto ;
    public etatRendezVous: EtatRendezVousDto ;
     public doses: Array<DoseDto>;
     public effetIndesirables: Array<EffetIndesirableDto>;

}
