import { CanActivateFn } from '@angular/router';

export const authGuard: CanActivateFn = (
  route,
  state
) => {
  const isLoggedIn = true;

  console.log(
    'Auth Guard checking route:',
    state.url
  );

  return isLoggedIn;
};
