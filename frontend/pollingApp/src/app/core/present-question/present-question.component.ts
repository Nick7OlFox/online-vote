import { Component } from '@angular/core';
import { globals } from '../../app.component';

@Component({
  selector: 'app-present-question',
  templateUrl: './present-question.component.html',
  styleUrl: './present-question.component.css'
})
export class PresentQuestionComponent {
  message = globals.message;
}
