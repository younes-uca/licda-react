import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {VilleDto} from '/pages/controller/model/Ville.model';
import {VilleCriteria} from "/pages/controller/criteria/VilleCriteria.model";



export const VilleService = {

   getList(): Promise<AxiosResponse<VilleDto[]>> {
     return axios.get(API_URL + 'ville/');
   },

   save(item: VilleDto): Promise<AxiosResponse<VilleDto>> {
     return axios.post(API_URL + 'ville/', item);
   },

   update(item: VilleDto): Promise<AxiosResponse<VilleDto>> {
      return axios.put(API_URL + 'ville/', item);
   },

   delete(id: number): Promise<AxiosResponse<VilleDto>> {
      return axios.delete(API_URL + 'ville/id/'+ id);
   },

   deleteList(items: VilleDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'ville/multiple', items);
   },

   findPaginatedByCriteria(criteria:VilleCriteria):Promise<AxiosResponse<PaginatedList<VilleDto>>> {
     return axios.post<PaginatedList<VilleDto>>(API_URL + 'ville/find-paginated-by-criteria', criteria);
   }
};

