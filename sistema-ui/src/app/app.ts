import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Product } from './models/product';
import { ProductService } from './services/ProductService';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected readonly title = signal('sistema-ui');

  products = signal<Product[]>([]);

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