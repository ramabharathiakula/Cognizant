import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { provideStore } from '@ngrx/store';

import { CourseList } from './course-list';
import { courseReducer } from '../../store/course/course.reducer';

describe('CourseList', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseList],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting(),
        provideStore({
          course: courseReducer
        })
      ]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(CourseList);
    expect(fixture.componentInstance).toBeTruthy();
  });
});
