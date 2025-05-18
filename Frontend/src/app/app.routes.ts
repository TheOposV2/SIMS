import { Routes } from '@angular/router';
import { SupplierListComponent } from './suppliers/supplier-list/supplier-list.component';
import { ProductListComponent } from './products/product-list/product-list.component';

export const routes: Routes = [
    {path: "", redirectTo:"products", pathMatch: "full"},
    {path: "suppliers", component: SupplierListComponent },
    {path: "products", component: ProductListComponent }
];
