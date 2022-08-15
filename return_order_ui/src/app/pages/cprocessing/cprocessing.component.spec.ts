import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CprocessingComponent } from './cprocessing.component';

describe('CprocessingComponent', () => {
  let component: CprocessingComponent;
  let fixture: ComponentFixture<CprocessingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CprocessingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CprocessingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
