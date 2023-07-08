import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {EtatDoseDto} from '/pages/controller/model/EtatDose.model';
import {EtatDoseCriteria} from "/pages/controller/criteria/EtatDoseCriteria.model";



export const EtatDoseService = {

   getList(): Promise<AxiosResponse<EtatDoseDto[]>> {
     return axios.get(API_URL + 'etatDose/');
   },

   save(item: EtatDoseDto): Promise<AxiosResponse<EtatDoseDto>> {
     return axios.post(API_URL + 'etatDose/', item);
   },

   update(item: EtatDoseDto): Promise<AxiosResponse<EtatDoseDto>> {
      return axios.put(API_URL + 'etatDose/', item);
   },

   delete(id: number): Promise<AxiosResponse<EtatDoseDto>> {
      return axios.delete(API_URL + 'etatDose/id/'+ id);
   },

   deleteList(items: EtatDoseDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'etatDose/multiple', items);
   },

   findPaginatedByCriteria(criteria:EtatDoseCriteria):Promise<AxiosResponse<PaginatedList<EtatDoseDto>>> {
     return axios.post<PaginatedList<EtatDoseDto>>(API_URL + 'etatDose/find-paginated-by-criteria', criteria);
   }
};

