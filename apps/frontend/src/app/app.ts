import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {CustomerList} from './customer-list/customer-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CustomerList],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend');
}
