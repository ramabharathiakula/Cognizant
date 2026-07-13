import {
  HttpInterceptorFn
} from '@angular/common/http';

import {
  tap
} from 'rxjs';

export const loggingInterceptor:
  HttpInterceptorFn = (
    request,
    next
  ) => {

  console.log(
    'HTTP Request:',
    request.method,
    request.url
  );

  return next(request).pipe(
    tap({
      next: event => {
        console.log(
          'HTTP Response Event:',
          event
        );
      },

      error: error => {
        console.error(
          'HTTP Error:',
          error
        );
      }
    })
  );
};
