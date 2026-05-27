import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { ProductService } from '../../services/ProductService';

@Component({
  selector: 'app-product-edit',
  imports: [
    FormsModule,
    RouterLink,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './product-edit.html',
  styleUrl: './product-edit.scss',
})
export class ProductEdit implements OnInit {
  productId!: number;

  product = {
    name: '',
    description: '',
    price: 0,
    quantity: 0
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.productId = Number(this.route.snapshot.paramMap.get('id'));

    this.productService.findById(this.productId).subscribe({
      next: (data) => {
        this.product = {
          name: data.name,
          description: data.description,
          price: data.price,
          quantity: data.quantity
        };
      },
      error: (error) => {
        console.error('Erro ao buscar produto:', error);
      }
    });
  }

  onSubmit(): void {
    this.productService.updateProduct(this.productId, this.product).subscribe({
      next: (updatedProduct) => {
        console.log('Produto atualizado com sucesso:', updatedProduct);
        this.router.navigate(['/products']);
      },
      error: (error) => {
        console.error('Erro ao atualizar produto:', error);
      }
    });
  }
}