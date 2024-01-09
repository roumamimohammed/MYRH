import { TestBed } from '@angular/core/testing';

import { CreateOffreService } from './create-offre.service';

describe('CreateOffreService', () => {
  let service: CreateOffreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateOffreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
