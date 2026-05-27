import { Routes } from '@angular/router';

import { ProductList } from './pages/product-list/product-list';
import { ProductCreate } from './pages/product-create/product-create';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'products',
    pathMatch: 'full'
  },
  {
    path: 'products',
    component: ProductList
  },
  {
    path: 'products/new',
    component: ProductCreate
  }
];