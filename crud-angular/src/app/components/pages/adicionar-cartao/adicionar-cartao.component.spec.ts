import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarCartaoComponent } from './adicionar-cartao.component';

describe('AdicionarCartaoComponent', () => {
  let component: AdicionarCartaoComponent;
  let fixture: ComponentFixture<AdicionarCartaoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdicionarCartaoComponent]
    });
    fixture = TestBed.createComponent(AdicionarCartaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
