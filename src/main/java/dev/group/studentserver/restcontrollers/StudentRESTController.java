package dev.group.studentserver.restcontrollers;

import java.util.List;
import dev.group.studentserver.model.Student;
import dev.group.studentserver.model.Subject;
import dev.group.studentserver.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("student")
public class StudentRESTController {

    private final StudentService studentService;

    public StudentRESTController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Transactional
    @PostMapping("/addstudent")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student added to database";
    }

    @GetMapping(value = "{rollNumber}")
    public Student findStudentByRollNumber(@PathVariable Integer rollNumber){
        return studentService.findStudentByRollNumber(rollNumber);
    }

    @GetMapping(path = "course/{rollnumber}")
    public List<Subject> findSub(@PathVariable Integer rollnumber){
        return studentService.findSubByRollnumber(rollnumber);
    }

}
