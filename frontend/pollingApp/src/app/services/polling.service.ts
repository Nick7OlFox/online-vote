import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { globals } from '../app.component';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PollingService {

  questionPath: string = "/v1/question";
  votePath: string = "/v1/vote"

  constructor(private http: HttpClient, private router: Router) { }

  getCurrentQuestion() {
    let processName = "getCurrentQuestion"
    globals.startProcess(processName);
    this.http.get<any>(globals.baseUrl + this.questionPath + "/active").subscribe(
      (response) => {
        console.log(response);
        globals.message = response.question;
        globals.options = new Array<any>();
        response.listOfOptions.forEach((element: any) => {
          globals.options?.push(element);
        });
        console.log(globals.options);

        globals.stopProcess(processName);
      },
      (error) => {
        // TODO implement error
        console.log(error);

        globals.message = error.error;
        this.router.navigate(['error']);
        globals.stopProcess(processName);
      }
    )
  }

  voteOnOption(optionId: Number) {
    let processName = "voteOnOption"
    globals.startProcess(processName);
    const params = {};
    this.http.post<any>(globals.baseUrl + this.votePath + "?answerId=" + optionId, params).subscribe(
      (response) => {
        console.log(response);
        globals.stopProcess(processName);
      },
      (error) => {
        console.log(error);
        globals.message = error.error;
        this.router.navigate(['error']);
        globals.stopProcess(processName);
      }
    )
  }
}
