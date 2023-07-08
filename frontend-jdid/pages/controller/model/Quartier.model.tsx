import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {VilleDto} from 'pages/controller/model/Ville.model';

export class QuartierDto extends BaseDto{


    public id: number;
    public code: string;
    public libelle: string;
    public ville: VilleDto ;

}
