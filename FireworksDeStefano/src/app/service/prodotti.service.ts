import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Prodotto } from '../models/prodotto';


@Injectable({
  providedIn: 'root'
})
export class ProdottiService {

  private baseUrl = 'http://localhost:3001/products';

  constructor( private httpClient: HttpClient) { }

  cercaProdottoPerBarcode(barcode: string): Observable<Prodotto[]> {
    return this.httpClient.get<Prodotto[]>(`${this.baseUrl}/searchbarcode?barcode=${barcode}`);
  }
}
