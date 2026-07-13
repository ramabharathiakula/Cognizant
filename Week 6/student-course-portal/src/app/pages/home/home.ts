import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {
  studentName: string = 'Rama Bharathi';
  studentId: string = 'STU001';
  gpa: number = 3.8;
  currentDate: Date = new Date();

  ngOnInit(): void {
    console.log('Home component initialized');
  }

  changeStudentName(): void {
    this.studentName = 'Rama Bharathi Akula';
  }
}
