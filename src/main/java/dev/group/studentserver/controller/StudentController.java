package dev.group.studentserver.controller;

import java.util.List;
import dev.group.studentserver.model.Student;
import dev.group.studentserver.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Transactional
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student added to database";
    }

    @GetMapping(value = "{rollNumber}")
    public Student findStudentByRollNumber(@PathVariable Integer rollNumber){
        return studentService.findStudentByRollNumber(rollNumber);
    }

}
