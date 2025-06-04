import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Asset} from "../model/asset";
import {AssetDto} from "../model/asset-dto";

@Injectable({
  providedIn: 'root'
})
export class AssetService {
  private apiUrl = 'http://localhost:8080/asset';

  constructor(private http: HttpClient) { }

  getAssetsForCompany(companyId: string): Observable<Asset[]> {
    return this.http.get<Asset[]>(`${this.apiUrl}/getAllForCompany?companyId=${companyId}&pageNumber=0&pageSize=50`);
  }

  addAssetToCompany(companyId: string, asset: AssetDto): Observable<Asset> {
    return this.http.post<Asset>(`${this.apiUrl}/addToCompany?companyId=${companyId}`, asset);
  }
}
