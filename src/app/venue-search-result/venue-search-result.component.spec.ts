import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VenueSearchResultComponent } from './venue-search-result.component';

describe('VenueSearchResultComponent', () => {
  let component: VenueSearchResultComponent;
  let fixture: ComponentFixture<VenueSearchResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VenueSearchResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VenueSearchResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
