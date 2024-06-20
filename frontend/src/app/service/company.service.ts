import { Injectable } from '@angular/core';
import {CompanyDto} from "../model/company-dto";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private apiUrl = 'http://localhost:8080/company';
  constructor(private http: HttpClient) { }

  getAllCompanies(pageIndex: number, pageSize: number): Observable<CompanyDto[]> {
    return this.http.get<CompanyDto[]>(this.apiUrl + '/getAll?pageNumber=' + pageIndex + '&pageSize=' + pageSize);
  }

  getAmountOfCompanies(): Observable<number> {
    return this.http.get<number>(this.apiUrl + '/count');
  }
}
