import { TestBed } from '@angular/core/testing';

import { provideRouter } from '@angular/router';

import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

import { provideStore } from '@ngrx/store';

import { App } from './app';
import { courseReducer } from './store/course/course.reducer';

describe('App', () => {

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [App],

      providers: [

        provideRouter([]),

        provideHttpClient(),
        provideHttpClientTesting(),

        provideStore({
          course: courseReducer
        })

      ]

    }).compileComponents();

  });

  it('should create the app', () => {

    const fixture = TestBed.createComponent(App);

    expect(fixture.componentInstance).toBeTruthy();

  });

  it('should render title', () => {

    const fixture = TestBed.createComponent(App);

    fixture.detectChanges();

    expect(fixture.nativeElement).toBeTruthy();

  });

});
