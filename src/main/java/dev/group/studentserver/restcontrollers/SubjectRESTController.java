package dev.group.studentserver.restcontrollers;

import dev.group.studentserver.model.Subject;
import dev.group.studentserver.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectRESTController {

    private final SubjectService subjectService;

    public SubjectRESTController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping("/addsubject")
    public String createSubject(@RequestBody Subject subject){
        subjectService.createSubject(subject);
        return "Subject added to database";
    }

    @GetMapping("{subCode}")
    public Subject getSubjectByCode(@PathVariable String subCode){
        return subjectService.getSubjectByCode(subCode);
    }

}
