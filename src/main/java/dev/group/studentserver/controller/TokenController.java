package dev.group.studentserver.controller;

import dev.group.studentserver.model.Student;
import dev.group.studentserver.model.TrackingToken;
import dev.group.studentserver.service.TrackingTokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/token")
public class TokenController {

    private final TrackingTokenService trackingTokenService;

    public TokenController(TrackingTokenService trackingTokenService) {
        this.trackingTokenService = trackingTokenService;
    }

    @GetMapping("/all")
    public String allTokenInfo(Model model){
        model.addAttribute("token",trackingTokenService.getAllTrackingTicket());
        return "fragments/token-fragments/alltokens";
    }

    @GetMapping(path = "/findRoll")
    public String searchStudent(Model model){
        model.addAttribute("token",new TrackingToken());
        return "fragments/token-fragments/findstudenttoken";
    }

    @PostMapping(value = "/search")
    public String getStudentByRollNumber(Model model,@ModelAttribute("token") TrackingToken trackingToken){
        model.addAttribute("token",trackingTokenService.getTrackingTokenByRollNumber(trackingToken.getStudents().getRollNumber()));
        if(trackingTokenService.getTrackingTokenByRollNumber(trackingToken.getStudents().getRollNumber()) == null){
            return null;
        }
        return "fragments/token-fragments/alltokens";
//        return "helloPage";
    }
}
