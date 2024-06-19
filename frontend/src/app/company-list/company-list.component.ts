import { Component } from '@angular/core';
import {MatList, MatListItem} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {MatFabButton} from "@angular/material/button";
import {MatPaginator} from "@angular/material/paginator";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-company-list',
  standalone: true,
  imports: [
    MatList,
    MatListItem,
    MatIcon,
    MatFabButton,
    MatPaginator,
    MatDivider
  ],
  templateUrl: './company-list.component.html',
  styleUrl: './company-list.component.css'
})
export class CompanyListComponent {

}
