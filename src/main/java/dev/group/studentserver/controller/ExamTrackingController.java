package dev.group.studentserver.controller;

import dev.group.studentserver.model.ExamTracking;
import dev.group.studentserver.service.ExamTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/examtracking")
public class ExamTrackingController {

    private final ExamTrackingService examTrackingService;

    public ExamTrackingController(ExamTrackingService examTrackingService) {
        this.examTrackingService = examTrackingService;
    }

    @GetMapping("/")
    public String testing(){
        return "Hello World";
    }

    @PostMapping("link")
    public String createTrackingTicket(@RequestParam Integer rollNumber,@RequestParam String subCode,@RequestParam String answerScriptId){
        return examTrackingService.createTrackingTicket(rollNumber,subCode,answerScriptId);
    }

    @GetMapping("all")
    public List<ExamTracking> getAllTrackingTicket(){
        return examTrackingService.getAllTrackingTicket();
    }
}
