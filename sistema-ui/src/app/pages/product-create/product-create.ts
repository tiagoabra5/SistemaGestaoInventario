import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

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

  onSubmit(): void {
    console.log('Produto digitado:', this.newProduct);
  }
}