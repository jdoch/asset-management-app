import {Component, Inject, inject, model} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CompanyDto} from "../../model/company-dto";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CompanyService} from "../../service/company.service";
import {AddressDto} from "../../model/address-dto";

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrl: './add-company.component.css'
})
export class AddCompanyComponent {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<AddCompanyComponent>,
    private companyService: CompanyService
  ) {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      street: [''],
      postalCode: [''],
      buildingNumber: [''],
      houseNumber: [''],
    });
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSubmit(): void {
    if (this.form.valid) {
      const addressDto: AddressDto = {
        street: this.form.value.street,
        postalCode: this.form.value.postalCode,
        buildingNumber: this.form.value.buildingNumber,
        houseNumber: this.form.value.houseNumber
      }
      const company: CompanyDto = {
        name: this.form.value.name,
        addressDto: addressDto
      }
      this.companyService.createCompany(company).subscribe(response => {
        this.dialogRef.close(response);
      }, error => {
        console.error('Error creating company', error);
      });
    }
  }
}
