import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {RendezVousDto} from '/pages/controller/model/RendezVous.model';
import {RendezVousCriteria} from "/pages/controller/criteria/RendezVousCriteria.model";



export const RendezVousService = {

   getList(): Promise<AxiosResponse<RendezVousDto[]>> {
     return axios.get(API_URL + 'rendezVous/');
   },

   save(item: RendezVousDto): Promise<AxiosResponse<RendezVousDto>> {
     return axios.post(API_URL + 'rendezVous/', item);
   },

   update(item: RendezVousDto): Promise<AxiosResponse<RendezVousDto>> {
      return axios.put(API_URL + 'rendezVous/', item);
   },

   delete(id: number): Promise<AxiosResponse<RendezVousDto>> {
      return axios.delete(API_URL + 'rendezVous/id/'+ id);
   },

   deleteList(items: RendezVousDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'rendezVous/multiple', items);
   },

   findPaginatedByCriteria(criteria:RendezVousCriteria):Promise<AxiosResponse<PaginatedList<RendezVousDto>>> {
     return axios.post<PaginatedList<RendezVousDto>>(API_URL + 'rendezVous/find-paginated-by-criteria', criteria);
   }
};

