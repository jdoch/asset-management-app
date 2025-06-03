import {Component, OnInit} from '@angular/core';
import {CompanyListEntryDto} from "../model/company-list-entry-dto";
import {CompanyService} from "../service/company.service";
import {PageEvent} from "@angular/material/paginator";
import {MatDialog} from "@angular/material/dialog";
import {AddCompanyComponent} from "../dialog/add-company/add-company.component";


@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrl: './company-list.component.css'
})
export class CompanyListComponent implements OnInit {
  companies: CompanyListEntryDto[] = [];
  length = 100;
  pageIndex = 0;
  pageSize = 2;

  constructor(private companyService: CompanyService, public dialog: MatDialog) {
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

  openDialog(): void {
    const dialogRef = this.dialog.open(AddCompanyComponent, {});
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getCompanies();
        this.companyService.getAmountOfCompanies().subscribe(
          (data) => {
            this.length = data;
          }
        );
      }
    });
  }

  deleteCompany(id: string): void {
    this.companyService.deleteCompany(id).subscribe(() => {
      this.getCompanies();
      this.companyService.getAmountOfCompanies().subscribe(data => this.length = data);
    });
  }
}
