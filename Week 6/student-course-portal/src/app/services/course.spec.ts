import { TestBed } from '@angular/core/testing';
import { CourseService } from './course';

describe('CourseService', () => {
  let service: CourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});

    service = TestBed.inject(CourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all courses', () => {
    const courses = service.getCourses();

    expect(courses.length).toBe(3);
  });

  it('should return course by id', () => {
    const course = service.getCourseById(1);

    expect(course).toBeTruthy();
    expect(course?.title).toBe('Angular Development');
  });

  it('should return undefined for invalid id', () => {
    expect(service.getCourseById(999)).toBeUndefined();
  });
});
