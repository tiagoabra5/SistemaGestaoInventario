import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';

import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { Product } from '../../models/product';
import { ProductService } from '../../services/ProductService';

@Component({
  selector: 'app-product-list',
  imports: [
    RouterLink,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss',
})
export class ProductList implements OnInit, AfterViewInit {
  displayedColumns: string[] = [
    'id',
    'name',
    'description',
    'price',
    'quantity',
    'createdAt',
    'actions'
  ];

  dataSource = new MatTableDataSource<Product>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  loadProducts(): void {
    this.productService.findAll().subscribe({
      next: (data) => {
        console.log('Produtos recebidos:', data);
        this.dataSource.data = data;
      },
      error: (error) => {
        console.error('Erro ao buscar produtos:', error);
      }
    });
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;

    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteProduct(id: number): void {
    const confirmDelete = confirm('Tem certeza que deseja excluir este produto?');

    if (!confirmDelete) {
      return;
    }

    this.productService.deleteProduct(id).subscribe({
      next: () => {
        console.log('Produto excluído com sucesso.');
        this.loadProducts();
      },
      error: (error) => {
        console.error('Erro ao excluir produto:', error);
      }
    });
  }
}