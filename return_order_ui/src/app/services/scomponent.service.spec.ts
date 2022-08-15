import { TestBed } from '@angular/core/testing';

import { ScomponentService } from './scomponent.service';

describe('ScomponentService', () => {
  let service: ScomponentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScomponentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
