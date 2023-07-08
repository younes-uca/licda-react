import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {EtatRendezVousDto} from '/pages/controller/model/EtatRendezVous.model';
import {EtatRendezVousCriteria} from "/pages/controller/criteria/EtatRendezVousCriteria.model";



export const EtatRendezVousService = {

   getList(): Promise<AxiosResponse<EtatRendezVousDto[]>> {
     return axios.get(API_URL + 'etatRendezVous/');
   },

   save(item: EtatRendezVousDto): Promise<AxiosResponse<EtatRendezVousDto>> {
     return axios.post(API_URL + 'etatRendezVous/', item);
   },

   update(item: EtatRendezVousDto): Promise<AxiosResponse<EtatRendezVousDto>> {
      return axios.put(API_URL + 'etatRendezVous/', item);
   },

   delete(id: number): Promise<AxiosResponse<EtatRendezVousDto>> {
      return axios.delete(API_URL + 'etatRendezVous/id/'+ id);
   },

   deleteList(items: EtatRendezVousDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'etatRendezVous/multiple', items);
   },

   findPaginatedByCriteria(criteria:EtatRendezVousCriteria):Promise<AxiosResponse<PaginatedList<EtatRendezVousDto>>> {
     return axios.post<PaginatedList<EtatRendezVousDto>>(API_URL + 'etatRendezVous/find-paginated-by-criteria', criteria);
   }
};

