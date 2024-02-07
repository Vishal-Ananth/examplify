package dev.group.studentserver.controller;

import dev.group.studentserver.model.TrackingToken;
import dev.group.studentserver.service.TrackingTokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/examtracking")
public class TrackingTokenController {

    private final TrackingTokenService trackingTokenService;

    public TrackingTokenController(TrackingTokenService trackingTokenService) {
        this.trackingTokenService = trackingTokenService;
    }

    @GetMapping("/")
    public String testing(){
        return "Hello World";
    }

    @PostMapping("link")
    public String createTrackingTicket(@RequestParam Integer rollNumber,@RequestParam String subCode, @RequestParam String answerScriptId){
        return trackingTokenService.createTrackingTicket(rollNumber,subCode,answerScriptId);
    }

    @GetMapping("all")
    public List<TrackingToken> getAllTrackingTicket(){
        return trackingTokenService.getAllTrackingTicket();
    }
}
