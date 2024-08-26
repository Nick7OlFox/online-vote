import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorScreenComponent } from './core/error-screen/error-screen.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        loadChildren: () =>
          import('./module/present-question/present-question.module').then((m) => m.PresentQuestionModule)
      },
      {
        path: 'voted',
        loadChildren: () =>
          import('./module/vote-confirmation/vote-confirmation.module').then((m) => m.VoteConfirmationModule)
      },
      {
        path: 'results',
        loadChildren: () =>
          import('./module/show-results/show-results.module').then((m) => m.ShowResultsModule)
      }
    ],
  },
  {
    path: 'error',
    component: ErrorScreenComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
