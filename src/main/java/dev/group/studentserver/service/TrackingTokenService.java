package dev.group.studentserver.service;

import dev.group.studentserver.dao.TrackingTokenRepository;
import org.springframework.stereotype.Service;

import dev.group.studentserver.model.*;

import java.util.List;

@Service
public class TrackingTokenService {

    private final StudentService studentService;
    private final SubjectService subjectService;

    private final TrackingTokenRepository trackingTokenRepository;

    public TrackingTokenService(StudentService studentService, SubjectService subjectService, TrackingTokenRepository trackingTokenRepository) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.trackingTokenRepository = trackingTokenRepository;
    }


    public String createTrackingTicket(Integer rollNumber, String subCode, String answerScriptId) {
        Student examinee = studentService.findStudentByRollNumber(rollNumber);
        Subject course = subjectService.getSubjectByCode(subCode);
        TrackingToken examTracking = new TrackingToken(answerScriptId,examinee,course);

        trackingTokenRepository.save(examTracking);

        return "Register Number "+examinee.getRollNumber()+" writing "+course.getSubCode()+" has been linked to answer script";

    }

    public List<TrackingToken> getAllTrackingTicket() {
        return trackingTokenRepository.findAll();
    }

    public List<TrackingToken> getTrackingTokenByRollNumber(Integer rollnumber) {
        return trackingTokenRepository.findTrackingTokensByStudents_RollNumber(rollnumber);
    }
}
