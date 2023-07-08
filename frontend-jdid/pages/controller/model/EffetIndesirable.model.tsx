import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {RendezVousDto} from 'pages/controller/model/RendezVous.model';

export class EffetIndesirableDto extends BaseDto{


    public id: number;
   public dateFait: Date;
    public description: string;
    public dateFaitMax: string ;
    public dateFaitMin: string ;
    public rendezVous: RendezVousDto ;

}
