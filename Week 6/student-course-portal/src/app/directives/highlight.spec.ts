import {
  ElementRef,
  Renderer2
} from '@angular/core';

import {
  Highlight
} from './highlight';

describe('Highlight', () => {
  it('should create an instance', () => {
    const elementRef = {
      nativeElement: document.createElement('div')
    } as ElementRef;

    const renderer = {
      setStyle: () => {},
      removeStyle: () => {}
    } as unknown as Renderer2;

    const directive = new Highlight(
      elementRef,
      renderer
    );

    expect(directive).toBeTruthy();
  });
});
