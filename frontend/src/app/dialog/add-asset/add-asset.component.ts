import {Component, Inject} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AssetService} from "../../service/asset.service";
import {AssetDto} from "../../model/asset-dto";

@Component({
  selector: 'app-add-asset',
  templateUrl: './add-asset.component.html',
  styleUrl: './add-asset.component.css'
})
export class AddAssetComponent {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<AddAssetComponent>,
    private assetService: AssetService,
    @Inject(MAT_DIALOG_DATA) public data: {companyId: string}
  ) {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      valuation: [0, Validators.required]
    });
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSubmit(): void {
    if (this.form.valid) {
      const asset: AssetDto = {
        name: this.form.value.name,
        valuation: this.form.value.valuation
      };
      this.assetService.addAssetToCompany(this.data.companyId, asset).subscribe(response => {
        this.dialogRef.close(response);
      }, error => console.error('Error creating asset', error));
    }
  }
}
