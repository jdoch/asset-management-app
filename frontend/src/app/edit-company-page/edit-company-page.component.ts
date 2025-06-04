import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CompanyService} from '../service/company.service';
import {AddressDto} from '../model/address-dto';
import {CompanyDto} from '../model/company-dto';
import {CompanyDetailsDto} from '../model/company-details-dto';

@Component({
  selector: 'app-edit-company-page',
  templateUrl: './edit-company-page.component.html',
  styleUrl: './edit-company-page.component.css'
})
export class EditCompanyPageComponent implements OnInit {
  form: FormGroup;
  id: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private companyService: CompanyService,
  ) {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      street: [''],
      postalCode: [''],
      buildingNumber: [''],
      houseNumber: [''],
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id') ?? '';
      if (this.id) {
        this.companyService.getCompanyDetails(this.id).subscribe((company: CompanyDetailsDto) => {
          this.form.patchValue({
            name: company.name,
            street: company.address?.street ?? '',
            postalCode: company.address?.postalCode ?? '',
            buildingNumber: company.address?.buildingNumber ?? '',
            houseNumber: company.address?.houseNumber ?? ''
          });
        });
      }
    });
  }

  onCancel(): void {
    this.router.navigate(['/']);
  }

  onSubmit(): void {
    if (this.form.valid) {
      const address: AddressDto = {
        street: this.form.value.street || null,
        postalCode: this.form.value.postalCode || null,
        buildingNumber: this.form.value.buildingNumber || null,
        houseNumber: this.form.value.houseNumber || null
      };
      const company: CompanyDto = {
        name: this.form.value.name,
        address: address
      };
      this.companyService.updateCompany(this.id, company).subscribe(() => {
        this.router.navigate(['/']);
      }, error => {
        console.error('Error updating company', error);
      });
    }
  }
}
