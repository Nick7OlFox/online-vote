import { Component } from '@angular/core';
import { PollingService } from '../../../services/polling.service';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrl: './page.component.css'
})
export class PageComponent {

  constructor(private pollingService: PollingService) { }
  reloadQuestion() {
    this.pollingService.getCurrentQuestion();
  }
}
