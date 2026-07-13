import {
  createAction,
  props
} from '@ngrx/store';

import {
  Course
} from '../../services/course';

export const loadCourses = createAction(
  '[Course] Load Courses'
);

export const loadCoursesSuccess = createAction(
  '[Course] Load Courses Success',
  props<{ courses: Course[] }>()
);

export const selectCourse = createAction(
  '[Course] Select Course',
  props<{ courseTitle: string }>()
);
