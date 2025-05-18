import { Supplier } from './supplier.model';

export interface Product {
  id: number;
  name: string;
  description: string;
  quantity: number;
  price: number;
  supplier: Supplier;
}