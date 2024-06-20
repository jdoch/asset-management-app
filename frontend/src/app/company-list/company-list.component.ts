import {Component, OnInit} from '@angular/core';
import {CompanyDto} from "../model/company-dto";
import {CompanyService} from "../service/company.service";
import {PageEvent} from "@angular/material/paginator";


@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrl: './company-list.component.css'
})
export class CompanyListComponent implements OnInit {
  companies: CompanyDto[] = [];
  length = 100;
  pageIndex = 0;
  pageSize = 2;

  constructor(private companyService: CompanyService) {
  }

  ngOnInit(): void {
    this.getCompanies();

    this.companyService.getAmountOfCompanies().subscribe(
      (data) => {
        this.length = data;
      }
    );
  }

  pageChangeEvent(event: PageEvent) {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getCompanies();
  }

  private getCompanies() {
    this.companyService.getAllCompanies(this.pageIndex, this.pageSize).subscribe(
      (data) => {
        this.companies = data;
      }
    );
  }
}
