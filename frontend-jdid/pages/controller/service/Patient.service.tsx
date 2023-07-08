import axios, { AxiosResponse } from "axios";
import { API_URL } from '/layout/AppConfig';
import {BaseCriteria} from "/pages/zynerator/criteria/BaseCriteria.model";
import {PaginatedList} from "/pages/zynerator/dto/PaginatedList.model";
import {BaseDto} from "/pages/zynerator/dto/BaseDto.model";
import {PatientDto} from '/pages/controller/model/Patient.model';
import {PatientCriteria} from "/pages/controller/criteria/PatientCriteria.model";



export const PatientService = {

   getList(): Promise<AxiosResponse<PatientDto[]>> {
     return axios.get(API_URL + 'patient/');
   },

   save(item: PatientDto): Promise<AxiosResponse<PatientDto>> {
     return axios.post(API_URL + 'patient/', item);
   },

   update(item: PatientDto): Promise<AxiosResponse<PatientDto>> {
      return axios.put(API_URL + 'patient/', item);
   },

   delete(id: number): Promise<AxiosResponse<PatientDto>> {
      return axios.delete(API_URL + 'patient/id/'+ id);
   },

   deleteList(items: PatientDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'patient/multiple', items);
   },

   findPaginatedByCriteria(criteria:PatientCriteria):Promise<AxiosResponse<PaginatedList<PatientDto>>> {
     return axios.post<PaginatedList<PatientDto>>(API_URL + 'patient/find-paginated-by-criteria', criteria);
   }
};

