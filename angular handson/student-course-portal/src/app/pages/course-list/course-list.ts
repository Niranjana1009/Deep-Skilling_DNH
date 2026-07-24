import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CourseCardComponent, Course } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  isLoading = true;
  courses: Course[] = [];
  selectedCourseId: number | null = null;

  ngOnInit(): void {
    setTimeout(() => {
      this.courses = [
        { id: 101, name: 'Angular Fundamentals', code: 'ANG101', credits: 3, gradeStatus: 'passed' },
        { id: 102, name: 'TypeScript Basics', code: 'TS102', credits: 2, gradeStatus: 'pending' },
        { id: 103, name: 'Node.js Essentials', code: 'NODE103', credits: 4, gradeStatus: 'failed' },
        { id: 104, name: 'Java Spring Boot', code: 'SPR104', credits: 3, gradeStatus: 'passed' },
        { id: 105, name: 'Database Design', code: 'DB105', credits: 2, gradeStatus: 'pending' }
      ];
      this.isLoading = false;
    }, 1500);
  }

  onEnroll(courseId: number): void {
    this.selectedCourseId = courseId;
  }

  // Using trackBy improves rendering performance when the list changes.
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}
