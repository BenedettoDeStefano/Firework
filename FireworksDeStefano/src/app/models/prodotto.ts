export interface Prodotto {
  id: string;
  nameProduct: string;
  barcode: string;
  //categories: categoria;
  totalWeight: number;
  price: number;
  dateAdding: Date;
  stock: number;
}
