import { Component, OnInit } from '@angular/core';
import { PollingService } from './services/polling.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'pollingApp';
  public globals: GlobalVariables = globals;

  constructor(private pollingService: PollingService, private router : Router){}
  ngOnInit(): void {
    // Navigate to the root path on application refresh
    this.router.navigate(['']);
    this.pollingService.getCurrentQuestion();
  }
}

type Nullable<T> = T | null;

export interface GlobalVariables {
  isLoading: boolean;
  baseUrl: String;
  message?: String;
  options?: Array<any>; // Change to options
  error: boolean;
  ongoingProcesses: Array<String>;
  startProcess(process: String): void;
  stopProcess(process: String): void;
}
export let globals: GlobalVariables = {
  isLoading: false,
  baseUrl: "http://localhost:8080/poll",
  error: false,
  ongoingProcesses: new Array<String>(),
  startProcess(process: String): void {
    this.ongoingProcesses.push(process);
    console.log(process + " STARTED => Ongoing=(" + this.ongoingProcesses.length + ")::[" + this.ongoingProcesses + "]");
    this.isLoading = true;
  },
  stopProcess(process: String): void {
    if (this.ongoingProcesses.includes(process))
      this.ongoingProcesses.splice(this.ongoingProcesses.indexOf(process));
    console.log(process + " ENDED => Ongoing=(" + this.ongoingProcesses.length + ")::[" + this.ongoingProcesses + "]");
    if (this.ongoingProcesses.length == 0)
      this.isLoading = false;
  }
};