package dev.group.studentserver.controller;

import dev.group.studentserver.model.Subject;
import dev.group.studentserver.service.StudentService;
import dev.group.studentserver.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping("add")
    public String createSubject(@RequestBody Subject subject){
        subjectService.createSubject(subject);
        return "Subject added to database";
    }

    @GetMapping("{subCode}")
    public Subject getSubjectByCode(@PathVariable String subCode){
        return subjectService.getSubjectByCode(subCode);
    }

}
