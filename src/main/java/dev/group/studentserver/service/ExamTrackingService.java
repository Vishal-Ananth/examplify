package dev.group.studentserver.service;

import dev.group.studentserver.dao.ExamTrackingRepository;
import org.springframework.stereotype.Service;

import dev.group.studentserver.model.*;

import java.util.List;

@Service
public class ExamTrackingService {

    private final StudentService studentService;
    private final SubjectService subjectService;

    private final ExamTrackingRepository examTrackingRepository;

    public ExamTrackingService(StudentService studentService, SubjectService subjectService, ExamTrackingRepository examTrackingRepository) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.examTrackingRepository = examTrackingRepository;
    }


    public String createTrackingTicket(Integer rollNumber, String subCode, String answerScriptId) {
        Student examinee = studentService.findStudentByRollNumber(rollNumber);
        Subject course = subjectService.getSubjectByCode(subCode);
        ExamTracking examTracking = new ExamTracking(examinee,course,answerScriptId);

        examTrackingRepository.save(examTracking);

        return "Register Number "+examinee.getRollNumber()+" writing "+course.getSubCode()+" has been linked to answer script";

    }

    public List<ExamTracking> getAllTrackingTicket() {
        return examTrackingRepository.findAll();
    }
}
