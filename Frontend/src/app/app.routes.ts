import { Routes } from '@angular/router';
import { SupplierListComponent } from './ui/suppliers/supplier-list/supplier-list.component';
import { ProductListComponent } from './ui/products/product-list/product-list.component';
import { LoginComponent } from './ui/login/login.component';

export const routes: Routes = [
    {path: "", redirectTo:"api/auth/login", pathMatch: "full"},
    {path: "api/auth/login", component: LoginComponent},
    {path: "api/supplier", component: SupplierListComponent },
    {path: "api/product", component: ProductListComponent }
];
