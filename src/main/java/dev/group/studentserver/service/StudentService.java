package dev.group.studentserver.service;

import dev.group.studentserver.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void createStudent(Student student);

    Student findStudentByRollNumber(Integer rollNumber);
}
