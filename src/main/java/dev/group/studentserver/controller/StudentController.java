package dev.group.studentserver.controller;

import dev.group.studentserver.model.Admin;
import dev.group.studentserver.model.Student;
import dev.group.studentserver.restcontrollers.StudentRESTController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "student")
public class StudentController {

    private final StudentRESTController studentRESTController;

    public StudentController(StudentRESTController studentRESTController) {
        this.studentRESTController = studentRESTController;
    }

    @GetMapping(path = "/allstudents")
    public String getAllStudents(Model model){
        model.addAttribute("students",studentRESTController.getAllStudents());
        return "/fragments/allstudents";
    }

//    @PostMapping(path = "/findRoll")
//    public String searchStudent(@ModelAttribute("student") Student student){
//        System.out.println(student);
//        return "helloPage";
//    }

    @GetMapping(path = "/{rollnumber}")
    public String getStudentByRollNumber(Model model,@PathVariable Integer rollnumber){
        model.addAttribute("students",studentRESTController.findStudentByRollNumber(rollnumber));
        return "fragments/findstudent";
    }
}
