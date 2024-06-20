import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {CommonModule, NgForOf} from '@angular/common';
import {AppComponent} from "./app.component";
import {MatList, MatListItem} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatFabButton} from "@angular/material/button";
import {MatPaginator} from "@angular/material/paginator";
import {MatDivider} from "@angular/material/divider";
import {CompanyListComponent} from "./company-list/company-list.component";
import {BrowserModule} from "@angular/platform-browser";
import {provideHttpClient} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AddCompanyComponent} from "./dialog/add-company/add-company.component";
import {MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle} from "@angular/material/dialog";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInput} from "@angular/material/input";

@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    CompanyListComponent,
    AddCompanyComponent
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
    BrowserAnimationsModule,
    MatDialogContent,
    MatFormField,
    MatDialogActions,
    MatDialogClose,
    FormsModule,
    MatButton,
    MatInput,
    MatDialogTitle,
    ReactiveFormsModule,
    MatLabel
  ],
  providers: [provideHttpClient()],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
