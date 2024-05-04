package dev.group.studentserver.service;

import dev.group.studentserver.model.Student;
import dev.group.studentserver.model.Subject;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void createStudent(Student student);

    Student findStudentByRollNumber(Integer rollNumber);

    List<Subject> findSubByRollnumber(Integer rollNumber);

    String deleteStudent(Integer rollNumber);
}
