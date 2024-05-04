package dev.group.studentserver.restcontrollers;

import dev.group.studentserver.model.Subject;
import dev.group.studentserver.service.implementation.SubjectServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectRESTController {

    private final SubjectServiceImpl subjectServiceImpl;

    public SubjectRESTController(SubjectServiceImpl subjectServiceImpl) {
        this.subjectServiceImpl = subjectServiceImpl;
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects(){
        return subjectServiceImpl.getAllSubjects();
    }

    @PostMapping("/addsubject")
    public String createSubject(@RequestBody Subject subject){
        subjectServiceImpl.createSubject(subject);
        return "Subject added to database";
    }

    @GetMapping("{subCode}")
    public Subject getSubjectByCode(@PathVariable String subCode){
        return subjectServiceImpl.getSubjectByCode(subCode);
    }

}
