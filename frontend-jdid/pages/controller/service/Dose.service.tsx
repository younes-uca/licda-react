import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {DoseDto} from '/pages/controller/model/Dose.model';
import {DoseCriteria} from "/pages/controller/criteria/DoseCriteria.model";



export const DoseService = {

   getList(): Promise<AxiosResponse<DoseDto[]>> {
     return axios.get(API_URL + 'dose/');
   },

   save(item: DoseDto): Promise<AxiosResponse<DoseDto>> {
     return axios.post(API_URL + 'dose/', item);
   },

   update(item: DoseDto): Promise<AxiosResponse<DoseDto>> {
      return axios.put(API_URL + 'dose/', item);
   },

   delete(id: number): Promise<AxiosResponse<DoseDto>> {
      return axios.delete(API_URL + 'dose/id/'+ id);
   },

   deleteList(items: DoseDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'dose/multiple', items);
   },

   findPaginatedByCriteria(criteria:DoseCriteria):Promise<AxiosResponse<PaginatedList<DoseDto>>> {
     return axios.post<PaginatedList<DoseDto>>(API_URL + 'dose/find-paginated-by-criteria', criteria);
   }
};

