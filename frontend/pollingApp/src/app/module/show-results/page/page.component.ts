import { Component } from '@angular/core';
import { globals } from '../../../app.component';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrl: './page.component.css'
})
export class PageComponent {
  message = globals.message;
  options = globals.options;
}
