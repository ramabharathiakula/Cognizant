import { Component, EventEmitter, Input, Output } from '@angular/core';
import { UpperCasePipe } from '@angular/common';
import { Highlight } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-card',
  imports: [
    UpperCasePipe,
    Highlight,
    CreditLabelPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {
  @Input() title: string = '';
  @Input() instructor: string = '';
  @Input() credits: number = 0;

  @Output() enroll = new EventEmitter<string>();

  enrollCourse(): void {
    this.enroll.emit(this.title);
  }
}
