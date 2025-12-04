import {Component} from '@angular/core';
import {Customer} from './customer';
import {CurrencyPipe} from '@angular/common';

@Component({
  selector: 'app-customer-list',
  imports: [
    CurrencyPipe
  ],
  templateUrl: './customer-list.html',
  styleUrl: './customer-list.scss',
  styles: "h2 {color: navy;}"
})
export class CustomerList {

  customerList: Customer[] = [
    new Customer("123", "Peter", "Pan", "test@peter.com", 5000),
    new Customer("1234", "Peter", "Duck", "duck@peter.com", 100),
  ];
}
