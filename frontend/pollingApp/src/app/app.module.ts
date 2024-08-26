import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoadingScreenComponent } from './core/loading-screen/loading-screen.component';
import { PresentQuestionComponent } from './core/present-question/present-question.component';
import { ErrorScreenComponent } from './core/error-screen/error-screen.component';
import { VoteConfirmationComponent } from './core/vote-confirmation/vote-confirmation.component';

@NgModule({
  declarations: [
    AppComponent,
    LoadingScreenComponent,
    PresentQuestionComponent,
    ErrorScreenComponent,
    VoteConfirmationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
