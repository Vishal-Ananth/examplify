package dev.group.studentserver.restcontrollers;

import dev.group.studentserver.model.TrackingToken;
import dev.group.studentserver.service.implementation.TrackingTokenServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/examtracking")
public class TrackingTokenRESTController {

    private final TrackingTokenServiceImpl trackingTokenServiceImpl;

    public TrackingTokenRESTController(TrackingTokenServiceImpl trackingTokenServiceImpl) {
        this.trackingTokenServiceImpl = trackingTokenServiceImpl;
    }

    @GetMapping("/")
    public String testing(){
        return "Hello World";
    }

    @PostMapping("link")
    public String createTrackingTicket(@RequestParam Integer rollNumber,@RequestParam String subCode, @RequestParam String answerScriptId){
        return trackingTokenServiceImpl.createTrackingTicket(rollNumber,subCode,answerScriptId);
    }

    @GetMapping("all")
    public List<TrackingToken> getAllTrackingTicket(){
        return trackingTokenServiceImpl.getAllTrackingTicket();
    }
}
