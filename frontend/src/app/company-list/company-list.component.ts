import {Component, OnInit} from '@angular/core';
import {MatList, MatListItem} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {MatFabButton} from "@angular/material/button";
import {MatPaginator} from "@angular/material/paginator";
import {MatDivider} from "@angular/material/divider";
import {CompanyDto} from "../model/company-dto";
import {NgForOf} from "@angular/common";
import {CompanyService} from "../service/company.service";

@Component({
  selector: 'app-company-list',
  standalone: true,
  imports: [
    MatList,
    MatListItem,
    MatIcon,
    MatFabButton,
    MatPaginator,
    MatDivider,
    NgForOf
  ],
  templateUrl: './company-list.component.html',
  styleUrl: './company-list.component.css'
})
export class CompanyListComponent implements OnInit {
  companies: CompanyDto[] = [];

  constructor(private companyService: CompanyService) { }

  ngOnInit(): void {
    this.companies = this.companyService.getAllCompanies();
  }
}
