import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {MedecinDto} from '/pages/controller/model/Medecin.model';
import {MedecinCriteria} from "/pages/controller/criteria/MedecinCriteria.model";



export const MedecinService = {

   getList(): Promise<AxiosResponse<MedecinDto[]>> {
     return axios.get(API_URL + 'medecin/');
   },

   save(item: MedecinDto): Promise<AxiosResponse<MedecinDto>> {
     return axios.post(API_URL + 'medecin/', item);
   },

   update(item: MedecinDto): Promise<AxiosResponse<MedecinDto>> {
      return axios.put(API_URL + 'medecin/', item);
   },

   delete(id: number): Promise<AxiosResponse<MedecinDto>> {
      return axios.delete(API_URL + 'medecin/id/'+ id);
   },

   deleteList(items: MedecinDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'medecin/multiple', items);
   },

   findPaginatedByCriteria(criteria:MedecinCriteria):Promise<AxiosResponse<PaginatedList<MedecinDto>>> {
     return axios.post<PaginatedList<MedecinDto>>(API_URL + 'medecin/find-paginated-by-criteria', criteria);
   }
};

