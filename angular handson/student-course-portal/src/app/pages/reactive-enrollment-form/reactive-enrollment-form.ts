import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollmentForm!: FormGroup;

  constructor(private readonly fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollmentForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email], [this.emailTakenValidator]],
      courseId: ['', [Validators.required, this.courseCodeValidator]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // This getter keeps the form array access simple and reusable across the template.
  get additionalCourses(): FormArray {
    return this.enrollmentForm.get('additionalCourses') as FormArray;
  }

  addAnotherCourse(): void {
    this.additionalCourses.push(this.fb.control(''));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    console.log(this.enrollmentForm.value);
    console.log(this.enrollmentForm.getRawValue());
  }

  private emailTakenValidator(control: AbstractControl): Observable<ValidationErrors | null> {
    const value = control.value || '';
    return of(value.includes('test@') ? { emailTaken: true } : null).pipe(delay(800));
  }

  courseCodeValidator(control: AbstractControl): ValidationErrors | null {
    const value = (control.value || '').toString();
    return value.startsWith('XX') ? { invalidCourseCode: true } : null;
  }
}
