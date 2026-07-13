import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Header } from './components/header/header';
import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollment } from './pages/reactive-enrollment/reactive-enrollment';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    Header,
    Home,
    CourseList,
    EnrollmentForm,
    ReactiveEnrollment
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
}
