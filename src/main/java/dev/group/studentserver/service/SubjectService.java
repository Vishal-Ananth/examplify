package dev.group.studentserver.service;

import dev.group.studentserver.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();

    void createSubject(Subject subject);

    Subject getSubjectByCode(String subCode);
}
