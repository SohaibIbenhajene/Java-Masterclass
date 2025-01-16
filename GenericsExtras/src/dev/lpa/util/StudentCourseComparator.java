package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.Comparator;

public class StudentCourseComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getCourse().compareTo(o2.getCourse());
    }
}
