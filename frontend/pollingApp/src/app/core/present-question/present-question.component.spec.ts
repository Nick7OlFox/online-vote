import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PresentQuestionComponent } from './present-question.component';

describe('PresentQuestionComponent', () => {
  let component: PresentQuestionComponent;
  let fixture: ComponentFixture<PresentQuestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PresentQuestionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PresentQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
