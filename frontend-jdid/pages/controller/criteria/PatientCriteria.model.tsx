import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {GenderCriteria} from 'GenderCriteria.model';
import {VilleCriteria} from 'VilleCriteria.model';




export class PatientCriteria  extends  BaseCriteria {


    public id: number;

    public ipp: string;
    public ippLike: string;
    public email: string;
    public emailLike: string;
    public cin: string;
    public cinLike: string;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
     public age: number;
     public ageMin: number;
     public ageMax: number;
  public ville: VilleCriteria ;
  public villes: Array<VilleCriteria> ;
  public gender: GenderCriteria ;
  public genders: Array<GenderCriteria> ;


}
