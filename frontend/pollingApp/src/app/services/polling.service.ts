import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { globals } from '../app.component';
import { response } from 'express';
import { log } from 'console';

@Injectable({
  providedIn: 'root'
})
export class PollingService {

  questionPath: string = "/v1/question";

  constructor(private http: HttpClient) { }

  getCurrentQuestion() {
    let processName = "getCurrentQuestion"
    globals.startProcess(processName);
    this.http.get<any>(globals.baseUrl + this.questionPath + "/active").subscribe(
      (response) => {
        console.log(response);
        globals.message = response.question;
        globals.stopProcess(processName);
      },
      (error) => {
        // TODO implement error
        console.log(error);
        
        globals.message = error.error;
        globals.error = true;
        globals.stopProcess(processName);
      }
    )
  }
}
