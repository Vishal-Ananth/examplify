package dev.group.studentserver.service.implementation;

import dev.group.studentserver.dao.SubjectRepository;
import dev.group.studentserver.model.Subject;
import dev.group.studentserver.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }



    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectByCode(String subCode) {
        return subjectRepository.findBySubCode(subCode);
    }
}
