import {Routes} from '@angular/router';
import {CompanyListComponent} from './company-list/company-list.component';
import {EditCompanyPageComponent} from './edit-company-page/edit-company-page.component';

export const routes: Routes = [
  {path: '', component: CompanyListComponent},
  {path: 'company/:id', component: EditCompanyPageComponent},
  {path: '**', redirectTo: ''}
];
