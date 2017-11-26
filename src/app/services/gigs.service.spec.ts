import { TestBed, inject } from '@angular/core/testing';

import { GigsService } from './gigs.service';

describe('GigsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GigsService]
    });
  });

  it('should be created', inject([GigsService], (service: GigsService) => {
    expect(service).toBeTruthy();
  }));
});
