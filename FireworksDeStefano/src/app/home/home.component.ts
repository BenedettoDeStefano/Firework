import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../models/prodotto';
import { ProdottiService } from '../service/prodotti.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  barcode: string = '';
  quantity: number = 1;
  selectedQuantity: number = 1
  product: Prodotto | undefined;
  error: string = '';

  constructor(private prodottiService: ProdottiService) { }

  ngOnInit(): void {
  }

  cercaProdotto() {
    this.prodottiService.cercaProdottoPerBarcode(this.barcode).subscribe(
      (data: Prodotto[]) => {
        if (data.length > 0) {
          this.product = data[0];
          this.error = '';
        } else {
          this.product = undefined;
          this.error = 'Prodotto non trovato';
        }
      },
      (error) => {
        console.error(error);
        this.error = 'Errore nella ricerca del prodotto';
      }
    );
  }
}
