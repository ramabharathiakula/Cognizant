import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-enrollment-form',
  imports: [FormsModule],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentForm {
  studentName: string = '';
  email: string = '';
  course: string = '';
  submitted: boolean = false;

  onSubmit(): void {
    this.submitted = true;

    console.log('Enrollment submitted:', {
      studentName: this.studentName,
      email: this.email,
      course: this.course
    });
  }
}
