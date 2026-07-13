import { createReducer, on } from '@ngrx/store';
import { Course } from '../../services/course';
import {
  loadCoursesSuccess,
  selectCourse
} from './course.actions';

export interface CourseState {
  courses: Course[];
  selectedCourse: string;
}

export const initialState: CourseState = {
  courses: [],
  selectedCourse: ''
};

export const courseReducer = createReducer(
  initialState,

  on(
    loadCoursesSuccess,
    (state, { courses }) => ({
      ...state,
      courses
    })
  ),

  on(
    selectCourse,
    (state, { courseTitle }) => ({
      ...state,
      selectedCourse: courseTitle
    })
  )
);
