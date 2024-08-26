import { Component, OnInit } from '@angular/core';
import { globals } from '../../../app.component';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrl: './page.component.css'
})
export class PageComponent implements OnInit {

  message = globals.message;
  options = globals.options;
  totalNumberOfVotes = 0;

  ngOnInit() {
    if (this.options != undefined) {
      // Calculate total number of votes
      this.options.forEach((element: { numberOfVotes: number; }) => {
        this.totalNumberOfVotes += element.numberOfVotes;
      });

      // Calculate percentage for each option
      this.options.forEach((element: any) => {
        element.percentage = Math.trunc((element.numberOfVotes / this.totalNumberOfVotes) * 100);
      });

      // Sort options by percentage in descending order
      this.options.sort((a: any, b: any) => b.percentage - a.percentage);
    }
  }
}
