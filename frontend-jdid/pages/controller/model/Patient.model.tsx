import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {GenderDto} from 'pages/controller/model/Gender.model';
import {VilleDto} from 'pages/controller/model/Ville.model';

export class PatientDto extends BaseDto{


    public id: number;
    public ipp: string;
    public email: string;
    public cin: string;
    public nom: string;
    public prenom: string;
   public age: number;
    public ageMax: string ;
    public ageMin: string ;
    public ville: VilleDto ;
    public gender: GenderDto ;

}
