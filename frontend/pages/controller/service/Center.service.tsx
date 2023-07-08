import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {CenterDto} from '/pages/controller/model/Center.model';
import {CenterCriteria} from "/pages/controller/criteria/CenterCriteria.model";



export const CenterService = {

   getList(): Promise<AxiosResponse<CenterDto[]>> {
     return axios.get(API_URL + 'center/');
   },

   save(item: CenterDto): Promise<AxiosResponse<CenterDto>> {
     return axios.post(API_URL + 'center/', item);
   },

   update(item: CenterDto): Promise<AxiosResponse<CenterDto>> {
      return axios.put(API_URL + 'center/', item);
   },

   delete(id: number): Promise<AxiosResponse<CenterDto>> {
      return axios.delete(API_URL + 'center/id/'+ id);
   },

   deleteList(items: CenterDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'center/multiple', items);
   },

   findPaginatedByCriteria(criteria:CenterCriteria):Promise<AxiosResponse<PaginatedList<CenterDto>>> {
     return axios.post<PaginatedList<CenterDto>>(API_URL + 'center/find-paginated-by-criteria', criteria);
   }
};

