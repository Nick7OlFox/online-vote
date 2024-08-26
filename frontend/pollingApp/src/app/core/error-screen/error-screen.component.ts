import { Component } from '@angular/core';
import { globals } from '../../app.component';

@Component({
  selector: 'app-error-screen',
  templateUrl: './error-screen.component.html',
  styleUrl: './error-screen.component.css'
})
export class ErrorScreenComponent {
  errorMessage = globals.message;
}
