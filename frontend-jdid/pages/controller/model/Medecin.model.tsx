import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {CenterDto} from 'pages/controller/model/Center.model';

export class MedecinDto extends BaseDto{


    public id: number;
    public email: string;
    public cin: string;
    public nom: string;
    public prenom: string;
    public center: CenterDto ;

}
