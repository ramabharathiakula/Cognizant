import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  Observable,
  catchError,
  of
} from 'rxjs';

export interface ApiCourse {
  id: number;
  title: string;
  body: string;
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl =
    'https://jsonplaceholder.typicode.com/posts?_limit=5';

  constructor(
    private http: HttpClient
  ) {}

  getCourses(): Observable<ApiCourse[]> {
    return this.http
      .get<ApiCourse[]>(this.apiUrl)
      .pipe(
        catchError(error => {
          console.error(
            'API request failed:',
            error
          );

          return of([]);
        })
      );
  }
}
