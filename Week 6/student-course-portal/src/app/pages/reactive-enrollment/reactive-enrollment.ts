import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment',
  imports: [ReactiveFormsModule],
  templateUrl: './reactive-enrollment.html',
  styleUrl: './reactive-enrollment.css'
})
export class ReactiveEnrollment {
  enrollmentForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder) {
    this.enrollmentForm = this.formBuilder.group({
      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],

      course: [
        '',
        Validators.required
      ]
    });
  }

  onSubmit(): void {
    if (this.enrollmentForm.valid) {
      this.submitted = true;

      console.log(
        'Reactive enrollment submitted:',
        this.enrollmentForm.value
      );
    } else {
      this.enrollmentForm.markAllAsTouched();
    }
  }
}
