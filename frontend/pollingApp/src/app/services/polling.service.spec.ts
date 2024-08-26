import { TestBed } from '@angular/core/testing';

import { PollingService } from './polling.service';

describe('PollingServiceService', () => {
  let service: PollingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PollingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
