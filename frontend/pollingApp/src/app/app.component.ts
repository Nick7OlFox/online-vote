import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pollingApp';
  public globals: GlobalVariables = globals;
}

type Nullable<T> = T | null;

export interface GlobalVariables {
  isLoading: boolean;
  baseUrl: String;
  question?: String;
  options?: Array<any>; // Change to options
  error: boolean;
}
export let globals: GlobalVariables = {
  isLoading: false,
  baseUrl: "http://localhost:8080/ds",
  error: false
};