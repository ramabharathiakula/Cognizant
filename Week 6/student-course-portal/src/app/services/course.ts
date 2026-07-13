import { Injectable } from '@angular/core';

export interface Course {
  id: number;
  title: string;
  instructor: string;
  credits: number;
}

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [
    {
      id: 1,
      title: 'Angular Development',
      instructor: 'Dr. Sharma',
      credits: 4
    },
    {
      id: 2,
      title: 'Spring Boot Microservices',
      instructor: 'Prof. Kumar',
      credits: 3
    },
    {
      id: 3,
      title: 'Data Structures and Algorithms',
      instructor: 'Dr. Rao',
      credits: 4
    }
  ];

  getCourses(): Course[] {
    return this.courses;
  }

  getCourseById(id: number): Course | undefined {
    return this.courses.find(
      course => course.id === id
    );
  }
}
