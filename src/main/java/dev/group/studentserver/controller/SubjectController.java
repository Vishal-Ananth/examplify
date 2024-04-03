package dev.group.studentserver.controller;

import dev.group.studentserver.restcontrollers.SubjectRESTController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
