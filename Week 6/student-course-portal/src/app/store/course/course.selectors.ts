import {
  createFeatureSelector,
  createSelector
} from '@ngrx/store';

import {
  CourseState
} from './course.reducer';

export const selectCourseState =
  createFeatureSelector<CourseState>('course');

export const selectAllCourses = createSelector(
  selectCourseState,
  state => state.courses
);

export const selectSelectedCourse = createSelector(
  selectCourseState,
  state => state.selectedCourse
);
