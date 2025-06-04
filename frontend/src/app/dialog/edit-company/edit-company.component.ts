import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CompanyService} from "../../service/company.service";
import {AddressDto} from "../../model/address-dto";
import {CompanyDto} from "../../model/company-dto";
import {CompanyDetailsDto} from "../../model/company-details-dto";

@Component({
  selector: 'app-edit-company',
  templateUrl: './edit-company.component.html',
  styleUrl: './edit-company.component.css'
})
export class EditCompanyComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<EditCompanyComponent>,
    private companyService: CompanyService,
    @Inject(MAT_DIALOG_DATA) public data: {id: string}
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
    this.companyService.getCompanyDetails(this.data.id).subscribe((company: CompanyDetailsDto) => {
      this.form.patchValue({
        name: company.name,
        street: company.address?.street ?? '',
        postalCode: company.address?.postalCode ?? '',
        buildingNumber: company.address?.buildingNumber ?? '',
        houseNumber: company.address?.houseNumber ?? ''
      });
    });
  }

  onCancel(): void {
    this.dialogRef.close();
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
      this.companyService.updateCompany(this.data.id, company).subscribe(response => {
        this.dialogRef.close(response);
      }, error => {
        console.error('Error updating company', error);
      });
    }
  }
}
