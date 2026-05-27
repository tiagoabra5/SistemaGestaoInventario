import { Component, OnInit, signal } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { Product } from '../../models/product';
import { ProductService } from '../../services/ProductService';

@Component({
  selector: 'app-product-list',
  imports: [
    MatTableModule
  ],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss',
})
export class ProductList implements OnInit {
  products = signal<Product[]>([]);

  displayedColumns: string[] = [
    'id',
    'name',
    'description',
    'price',
    'quantity',
    'createdAt'
  ];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService.findAll().subscribe({
      next: (data) => {
        console.log('Produtos recebidos:', data);
        this.products.set(data);
      },
      error: (error) => {
        console.error('Erro ao buscar produtos:', error);
      }
    });
  }
}