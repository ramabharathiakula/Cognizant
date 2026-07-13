import {
  Component,
  OnInit
} from '@angular/core';

import {
  AsyncPipe
} from '@angular/common';

import {
  Store
} from '@ngrx/store';

import {
  Observable
} from 'rxjs';

import {
  CourseCard
} from '../../components/course-card/course-card';

import {
  Course,
  CourseService
} from '../../services/course';

import {
  ApiCourse,
  ApiService
} from '../../services/api';

import {
  loadCoursesSuccess,
  selectCourse
} from '../../store/course/course.actions';

import {
  selectAllCourses,
  selectSelectedCourse
} from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  imports: [
    CourseCard,
    AsyncPipe
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  courses$: Observable<Course[]>;
  selectedCourse$: Observable<string>;

  apiCourses: ApiCourse[] = [];

  constructor(
    private courseService: CourseService,
    private apiService: ApiService,
    private store: Store
  ) {
    this.courses$ =
      this.store.select(selectAllCourses);

    this.selectedCourse$ =
      this.store.select(selectSelectedCourse);
  }

  ngOnInit(): void {
    const courses =
      this.courseService.getCourses();

    this.store.dispatch(
      loadCoursesSuccess({ courses })
    );

    this.apiService
      .getCourses()
      .subscribe(data => {
        this.apiCourses = data;
      });
  }

  handleEnrollment(
    courseTitle: string
  ): void {
    this.store.dispatch(
      selectCourse({ courseTitle })
    );
  }
}
