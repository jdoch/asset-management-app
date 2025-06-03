import { Injectable } from '@angular/core';
import {CompanyListEntryDto} from "../model/company-list-entry-dto";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {CompanyDto} from "../model/company-dto";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private apiUrl = 'http://localhost:8080/company';
  constructor(private http: HttpClient) { }

  getAllCompanies(pageIndex: number, pageSize: number): Observable<CompanyListEntryDto[]> {
    return this.http.get<CompanyListEntryDto[]>(this.apiUrl + '/getAll?pageNumber=' + pageIndex + '&pageSize=' + pageSize);
  }

  getAmountOfCompanies(): Observable<number> {
    return this.http.get<number>(this.apiUrl + '/count');
  }

  createCompany(company: CompanyDto): Observable<CompanyDto> {
    return this.http.post<CompanyDto>(this.apiUrl + '/add', company);
  }

  deleteCompany(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete?id=${id}`);
  }
}
