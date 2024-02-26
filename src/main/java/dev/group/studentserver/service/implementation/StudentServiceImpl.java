package dev.group.studentserver.service.implementation;

import dev.group.studentserver.dao.StudentRepository;
import dev.group.studentserver.model.Student;
import dev.group.studentserver.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentByRollNumber(Integer rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }
}
