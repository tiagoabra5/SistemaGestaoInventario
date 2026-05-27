import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { ProductService } from '../../services/ProductService';

@Component({
  selector: 'app-product-create',
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './product-create.html',
  styleUrl: './product-create.scss',
})
export class ProductCreate {
  newProduct = {
    name: '',
    description: '',
    price: 0,
    quantity: 0
  };

  constructor(
    private productService: ProductService,
    private router: Router
  ) {}

  onSubmit(): void {
    this.productService.createProduct(this.newProduct).subscribe({
      next: (product) => {
        console.log('Produto cadastrado com sucesso:', product);
        this.router.navigate(['/products']);
      },
      error: (error) => {
        console.error('Erro ao cadastrar produto:', error);
      }
    });
  }
}