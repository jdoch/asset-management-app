import { Injectable } from '@angular/core';
import {CompanyDto} from "../model/company-dto";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private apiUrl = 'localhost:8080/company';
  constructor(private http: HttpClient) { }

  getAllCompanies(): CompanyDto[] {
    return [{ id: '12345', name: 'Company A'}, { id: '12345', name: 'Company B'}];
  }

  getAmountOfCompanies(): Observable<number> {
    return this.http.get<number>(this.apiUrl + '/count');
  }
}
