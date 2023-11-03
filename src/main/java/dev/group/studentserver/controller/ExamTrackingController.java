package dev.group.studentserver.controller;

import dev.group.studentserver.service.ExamTrackingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/examtracking")
public class ExamTrackingController {

    private final ExamTrackingService examTrackingService;

    public ExamTrackingController(ExamTrackingService examTrackingService) {
        this.examTrackingService = examTrackingService;
    }

    @GetMapping
    public String testing(){
        return "Hello World";
    }

    @PostMapping("link")
    public String createTrackingTicket(@RequestParam Integer rollNumber,@RequestParam String subCode,@RequestParam String answerScriptId){
        return examTrackingService.createTrackingTicket(rollNumber,subCode,answerScriptId);
    }
}
