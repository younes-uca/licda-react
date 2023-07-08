import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {EffetIndesirableDto} from '/pages/controller/model/EffetIndesirable.model';
import {EffetIndesirableCriteria} from "/pages/controller/criteria/EffetIndesirableCriteria.model";



export const EffetIndesirableService = {

   getList(): Promise<AxiosResponse<EffetIndesirableDto[]>> {
     return axios.get(API_URL + 'effetIndesirable/');
   },

   save(item: EffetIndesirableDto): Promise<AxiosResponse<EffetIndesirableDto>> {
     return axios.post(API_URL + 'effetIndesirable/', item);
   },

   update(item: EffetIndesirableDto): Promise<AxiosResponse<EffetIndesirableDto>> {
      return axios.put(API_URL + 'effetIndesirable/', item);
   },

   delete(id: number): Promise<AxiosResponse<EffetIndesirableDto>> {
      return axios.delete(API_URL + 'effetIndesirable/id/'+ id);
   },

   deleteList(items: EffetIndesirableDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'effetIndesirable/multiple', items);
   },

   findPaginatedByCriteria(criteria:EffetIndesirableCriteria):Promise<AxiosResponse<PaginatedList<EffetIndesirableDto>>> {
     return axios.post<PaginatedList<EffetIndesirableDto>>(API_URL + 'effetIndesirable/find-paginated-by-criteria', criteria);
   }
};

