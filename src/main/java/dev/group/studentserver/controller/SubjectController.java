package dev.group.studentserver.controller;

import dev.group.studentserver.model.Student;
import dev.group.studentserver.model.Subject;
import dev.group.studentserver.restcontrollers.SubjectRESTController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectRESTController subjectRESTController;

    public SubjectController(SubjectRESTController subjectRESTController) {
        this.subjectRESTController = subjectRESTController;
    }

    @GetMapping("/allsubjects")
    public String getAllCourses(Model model){
        model.addAttribute("courses",subjectRESTController.getAllSubjects());
        return "fragments/allcourse";
    }

    @GetMapping(path = "/add")
    public String toStudent(Model model){
        model.addAttribute("sub",new Subject());
        return "fragments/addsubject";
    }


    @PostMapping(value = "/add/info")
    public String addStudentInfo(Model model,@ModelAttribute("sub") Subject subject){
//        studentRESTController.createStudent(student);
        System.out.println(subject);
        if(subject==null){
            return null;
        }
        model.addAttribute("student",subjectRESTController.createSubject(subject));
        return "fragments/addsubject";
    }
}
