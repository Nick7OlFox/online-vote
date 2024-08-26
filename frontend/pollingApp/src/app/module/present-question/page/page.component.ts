import { Component } from '@angular/core';
import { globals } from '../../../app.component';
import { PollingService } from '../../../services/polling.service';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrl: './page.component.css'
})
export class PageComponent {
  message = globals.message;
  options = globals.options;

  constructor(private pollingService: PollingService){}

  public voteForOption(optionId: Number) {
    console.log(optionId);
    this.pollingService.voteOnOption(optionId);
  }
}
