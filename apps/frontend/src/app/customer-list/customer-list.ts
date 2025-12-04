import {Component} from '@angular/core';
import {Customer} from './customer';

@Component({
  selector: 'app-customer-list',
  imports: [],
  templateUrl: './customer-list.html',
  styleUrl: './customer-list.scss',
})
export class CustomerList {

  customerList: Customer[] = [
    new Customer("123", "Peter", "Pan"),
    new Customer("1234", "Peter", "Duck"),
  ];
}
