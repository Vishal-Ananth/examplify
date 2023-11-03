package dev.group.studentserver.controller;

import java.util.List;
import dev.group.studentserver.model.Student;
import dev.group.studentserver.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Transactional
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student added to database";
    }

    @GetMapping("{rollNumber}")
    public Student findStudentByRollNumber(@PathVariable Integer rollNumber){
        return studentService.findStudentByRollNumber(rollNumber);
    }

}
