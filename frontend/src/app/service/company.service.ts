import { Injectable } from '@angular/core';
import {CompanyDto} from "../model/company-dto";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor() { }

  getAllCompanies(): CompanyDto[] {
    return [{ id: '12345', name: 'Company A'}, { id: '12345', name: 'Company B'}];
  }

  getAmountOfCompanies(): number {
    return 100;
  }
}
