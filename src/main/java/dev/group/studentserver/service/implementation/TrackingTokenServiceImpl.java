package dev.group.studentserver.service.implementation;

import dev.group.studentserver.dao.TrackingTokenRepository;
import dev.group.studentserver.service.StudentService;
import dev.group.studentserver.service.TrackingTokenService;
import dev.group.studentserver.service.implementation.SubjectServiceImpl;
import org.springframework.stereotype.Service;

import dev.group.studentserver.model.*;

import java.util.List;

@Service
public class TrackingTokenServiceImpl implements TrackingTokenService {

    private final StudentService studentService;
    private final SubjectServiceImpl subjectServiceImpl;

    private final TrackingTokenRepository trackingTokenRepository;

    public TrackingTokenServiceImpl(StudentService studentService, SubjectServiceImpl subjectServiceImpl, TrackingTokenRepository trackingTokenRepository) {
        this.studentService = studentService;
        this.subjectServiceImpl = subjectServiceImpl;
        this.trackingTokenRepository = trackingTokenRepository;
    }


    @Override
    public String createTrackingTicket(Integer rollNumber, String subCode, String answerScriptId) {
        Student examinee = studentService.findStudentByRollNumber(rollNumber);
        Subject course = subjectServiceImpl.getSubjectByCode(subCode);
        TrackingToken examTracking = new TrackingToken(answerScriptId,examinee,course);

        trackingTokenRepository.save(examTracking);

        return "Register Number "+examinee.getRollNumber()+" writing "+course.getSubCode()+" has been linked to answer script";

    }

    @Override
    public List<TrackingToken> getAllTrackingTicket() {
        return trackingTokenRepository.findAll();
    }
}
