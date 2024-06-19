import {Component, OnInit} from '@angular/core';
import {CompanyDto} from "../model/company-dto";
import {CompanyService} from "../service/company.service";


@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrl: './company-list.component.css'
})
export class CompanyListComponent implements OnInit {
  companies: CompanyDto[] = [];
  length = 100;

  constructor(private companyService: CompanyService) {
  }

  ngOnInit(): void {
    this.companies = this.companyService.getAllCompanies();

    this.companyService.getAmountOfCompanies().subscribe(
      (data) => {
        this.length = data;
      }
    );
  }
}
