import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {QuartierDto} from '/pages/controller/model/Quartier.model';
import {QuartierCriteria} from "/pages/controller/criteria/QuartierCriteria.model";



export const QuartierService = {

   getList(): Promise<AxiosResponse<QuartierDto[]>> {
     return axios.get(API_URL + 'quartier/');
   },

   save(item: QuartierDto): Promise<AxiosResponse<QuartierDto>> {
     return axios.post(API_URL + 'quartier/', item);
   },

   update(item: QuartierDto): Promise<AxiosResponse<QuartierDto>> {
      return axios.put(API_URL + 'quartier/', item);
   },

   delete(id: number): Promise<AxiosResponse<QuartierDto>> {
      return axios.delete(API_URL + 'quartier/id/'+ id);
   },

   deleteList(items: QuartierDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'quartier/multiple', items);
   },

   findPaginatedByCriteria(criteria:QuartierCriteria):Promise<AxiosResponse<PaginatedList<QuartierDto>>> {
     return axios.post<PaginatedList<QuartierDto>>(API_URL + 'quartier/find-paginated-by-criteria', criteria);
   }
};

