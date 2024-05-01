package dev.group.studentserver.restcontrollers;

import dev.group.studentserver.model.TrackingToken;
import dev.group.studentserver.service.TrackingTokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tracking")
public class TrackingTokenRESTController {

    private final TrackingTokenService trackingTokenService;

    public TrackingTokenRESTController(TrackingTokenService trackingTokenService) {
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

    @GetMapping("{rollnumber}")
    public List<TrackingToken> findTrackingToken(@PathVariable Integer rollnumber ){
        return trackingTokenService.getTrackingTokenByRollNumber(rollnumber);
    }
}
