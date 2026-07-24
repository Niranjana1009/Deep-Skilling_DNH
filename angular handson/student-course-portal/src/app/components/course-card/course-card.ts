import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { CreditLabelPipe } from '../../pipes/credit-label/credit-label-pipe';

export interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
}

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input({ required: true }) course!: Course;
  @Output() enroll = new EventEmitter<number>();

  expanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('CourseCard changed:', {
        previous: changes['course'].previousValue,
        current: changes['course'].currentValue
      });
    }
  }

  onEnrollClick(): void {
    this.enroll.emit(this.course.id);
  }

  toggleDetails(): void {
    this.expanded = !this.expanded;
  }

  getBorderStyle(): string {
    switch (this.course.gradeStatus) {
      case 'passed':
        return '4px solid green';
      case 'failed':
        return '4px solid red';
      default:
        return '4px solid gray';
    }
  }

  // This getter keeps the card styling logic centralized and easy to reuse.
  get cardClasses(): Record<string, boolean> {
    return {
      'card--enrolled': this.course.id % 2 === 0,
      'card--full': this.course.credits >= 3,
      'card--expanded': this.expanded
    };
  }
}
