import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatSlideToggle} from "@angular/material/slide-toggle";
import {MatButton} from "@angular/material/button";
import {MatBadge} from "@angular/material/badge";
import {CompanyListComponent} from "./company-list/company-list.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatSlideToggle, MatButton, MatBadge, CompanyListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
