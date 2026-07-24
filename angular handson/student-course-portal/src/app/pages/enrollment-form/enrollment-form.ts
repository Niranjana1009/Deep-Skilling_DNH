import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { HighlightDirective } from '../../directives/highlight/highlight';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [CommonModule, FormsModule, HighlightDirective],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentFormComponent {
  @ViewChild('enrollmentForm') enrollmentForm!: NgForm;

  studentName = '';
  studentEmail = '';
  courseId = '';
  preferredSemester = '';
  odd = false;
  even = false;
  agreeToTerms = false;
  submitted = false;

  onSubmit(): void {
    console.log(this.enrollmentForm.value);
    console.log(this.enrollmentForm.valid);
    this.submitted = true;
  }

  resetForm(): void {
    this.enrollmentForm.reset();
    this.submitted = false;
  }
}
