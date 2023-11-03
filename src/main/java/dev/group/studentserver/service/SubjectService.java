package dev.group.studentserver.service;

import dev.group.studentserver.dao.SubjectRepository;
import dev.group.studentserver.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }
}
