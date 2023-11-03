package dev.group.studentserver.service;

import dev.group.studentserver.dao.StudentRepository;
import dev.group.studentserver.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student findStudentByRollNumber(Integer rollnumber) {
        return studentRepository.findByRollNumber(rollnumber);
    }
}
