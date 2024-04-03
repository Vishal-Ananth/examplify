package dev.group.studentserver.controller;

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

    @GetMapping(path = "/findRoll")
    public String searchStudent(Model model){
        model.addAttribute("stud",new Student());
        return "fragments/findstudent";
    }

    @PostMapping(value = "/search")
    public String getStudentByRollNumber(Model model,@ModelAttribute("stud") Student student){
        model.addAttribute("students",studentRESTController.findStudentByRollNumber(student.getRollNumber()));
        if(studentRESTController.findStudentByRollNumber(student.getRollNumber()) == null){
            return null;
        }
        return "fragments/allstudents";
//        return "helloPage";
    }

    @GetMapping(path = "/add")
    public String toStudent(Model model){
        model.addAttribute("stud",new Student());
        return "fragments/addstudent";
    }


    @PostMapping(value = "/add/info")
    public String addStudentInfo(Model model,@ModelAttribute("stud") Student student){
//        studentRESTController.createStudent(student);
        System.out.println(student);
        if(student==null){
            return null;
        }
        model.addAttribute("student",studentRESTController.createStudent(student));
        return "fragments/addstudent";
    }

    @GetMapping("/update")
    public String update(Model model){
        model.addAttribute("stud",new Student());
        return "fragments/edit-find";
    }

    @PostMapping(value = "/update/info")
    public String updateStudentInfo(Model model,@ModelAttribute("stud") Student student){
        model.addAttribute("students",studentRESTController.findStudentByRollNumber(student.getRollNumber()));
        if(studentRESTController.findStudentByRollNumber(student.getRollNumber()) == null){
            return null;
        }
        System.out.println(studentRESTController.findStudentByRollNumber(student.getRollNumber()));
        return "fragments/edit-table";
    }



}
