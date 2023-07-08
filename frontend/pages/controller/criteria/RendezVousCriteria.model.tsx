import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';

import {EtatRendezVousCriteria} from 'EtatRendezVousCriteria.model';
import {CenterCriteria} from 'CenterCriteria.model';
import {CategorieRdvCriteria} from 'CategorieRdvCriteria.model';
import {MedecinCriteria} from 'MedecinCriteria.model';
import {PatientCriteria} from 'PatientCriteria.model';
import {EffetIndesirableCriteria} from 'EffetIndesirableCriteria.model';
import {DoseCriteria} from 'DoseCriteria.model';




export class RendezVousCriteria  extends  BaseCriteria {


    public id: number;

    public datePriseRdv: Date;
    public datePriseRdvFrom: Date;
    public datePriseRdvTo: Date;
  public patient: PatientCriteria ;
  public patients: Array<PatientCriteria> ;
  public center: CenterCriteria ;
  public centers: Array<CenterCriteria> ;
  public medecin: MedecinCriteria ;
  public medecins: Array<MedecinCriteria> ;
  public categorieRdv: CategorieRdvCriteria ;
  public categorieRdvs: Array<CategorieRdvCriteria> ;
  public etatRendezVous: EtatRendezVousCriteria ;
  public etatRendezVouss: Array<EtatRendezVousCriteria> ;
      public doses: Array<DoseCriteria>;
      public effetIndesirables: Array<EffetIndesirableCriteria>;


}
