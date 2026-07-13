import {
  ApplicationConfig,
  provideBrowserGlobalErrorListeners,
  provideZonelessChangeDetection
} from '@angular/core';

import {
  provideRouter
} from '@angular/router';

import {
  provideHttpClient,
  withInterceptors
} from '@angular/common/http';

import {
  provideStore
} from '@ngrx/store';

import {
  routes
} from './app.routes';

import {
  loggingInterceptor
} from './interceptors/logging-interceptor';

import {
  courseReducer
} from './store/course/course.reducer';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZonelessChangeDetection(),

    provideRouter(routes),

    provideHttpClient(
      withInterceptors([
        loggingInterceptor
      ])
    ),

    provideStore({
      course: courseReducer
    })
  ]
};
