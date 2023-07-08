import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {CategorieRdvDto} from '/pages/controller/model/CategorieRdv.model';
import {CategorieRdvCriteria} from "/pages/controller/criteria/CategorieRdvCriteria.model";



export const CategorieRdvService = {

   getList(): Promise<AxiosResponse<CategorieRdvDto[]>> {
     return axios.get(API_URL + 'categorieRdv/');
   },

   save(item: CategorieRdvDto): Promise<AxiosResponse<CategorieRdvDto>> {
     return axios.post(API_URL + 'categorieRdv/', item);
   },

   update(item: CategorieRdvDto): Promise<AxiosResponse<CategorieRdvDto>> {
      return axios.put(API_URL + 'categorieRdv/', item);
   },

   delete(id: number): Promise<AxiosResponse<CategorieRdvDto>> {
      return axios.delete(API_URL + 'categorieRdv/id/'+ id);
   },

   deleteList(items: CategorieRdvDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'categorieRdv/multiple', items);
   },

   findPaginatedByCriteria(criteria:CategorieRdvCriteria):Promise<AxiosResponse<PaginatedList<CategorieRdvDto>>> {
     return axios.post<PaginatedList<CategorieRdvDto>>(API_URL + 'categorieRdv/find-paginated-by-criteria', criteria);
   }
};

