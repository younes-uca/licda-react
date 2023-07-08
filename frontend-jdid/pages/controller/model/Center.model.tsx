import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {QuartierDto} from 'pages/controller/model/Quartier.model';

export class CenterDto extends BaseDto{


    public id: number;
    public code: string;
    public libelle: string;
    public quartier: QuartierDto ;

}
