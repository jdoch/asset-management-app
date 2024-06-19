import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {CommonModule, NgForOf} from '@angular/common';
import {AppComponent} from "./app.component";
import {MatList, MatListItem} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {MatFabButton} from "@angular/material/button";
import {MatPaginator} from "@angular/material/paginator";
import {MatDivider} from "@angular/material/divider";
import {CompanyListComponent} from "./company-list/company-list.component";
import {BrowserModule} from "@angular/platform-browser";
import {provideHttpClient} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    CompanyListComponent
  ],
  imports: [
    CommonModule,
    MatList,
    MatListItem,
    MatIcon,
    MatFabButton,
    MatPaginator,
    MatDivider,
    NgForOf,
    BrowserModule,
    BrowserAnimationsModule
  ],
  providers: [provideHttpClient()],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
