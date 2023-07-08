import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {GenderDto} from '/pages/controller/model/Gender.model';
import {GenderCriteria} from "/pages/controller/criteria/GenderCriteria.model";



export const GenderService = {

   getList(): Promise<AxiosResponse<GenderDto[]>> {
     return axios.get(API_URL + 'gender/');
   },

   save(item: GenderDto): Promise<AxiosResponse<GenderDto>> {
     return axios.post(API_URL + 'gender/', item);
   },

   update(item: GenderDto): Promise<AxiosResponse<GenderDto>> {
      return axios.put(API_URL + 'gender/', item);
   },

   delete(id: number): Promise<AxiosResponse<GenderDto>> {
      return axios.delete(API_URL + 'gender/id/'+ id);
   },

   deleteList(items: GenderDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'gender/multiple', items);
   },

   findPaginatedByCriteria(criteria:GenderCriteria):Promise<AxiosResponse<PaginatedList<GenderDto>>> {
     return axios.post<PaginatedList<GenderDto>>(API_URL + 'gender/find-paginated-by-criteria', criteria);
   }
};

