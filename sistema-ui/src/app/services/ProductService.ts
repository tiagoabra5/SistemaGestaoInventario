import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Product } from '../models/product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/products';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  createProduct(product: {
    name: string;
    description: string;
    price: number;
    quantity: number;
  }): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
  }

  deleteProduct(id: number) {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  findById(id: number) {
    return this.http.get<Product>(`${this.apiUrl}/${id}`);
  }
  
  updateProduct(id: number, product: {
    name: string;
    description: string;
    price: number;
    quantity: number;
  }) {
    return this.http.put<Product>(`${this.apiUrl}/${id}`, product);
  }
}