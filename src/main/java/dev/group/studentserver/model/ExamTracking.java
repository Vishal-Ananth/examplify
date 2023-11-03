package dev.group.studentserver.model;


import jakarta.persistence.*;

@Entity
public class ExamTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "rollnumber")
    private Student student;

    @OneToOne(mappedBy = "subCode")
    private Subject subject;

    private String answerScriptId;

    public ExamTracking(Student student, Subject subject, String answerScriptId) {
        this.student = student;
        this.subject = subject;
        this.answerScriptId = answerScriptId;
    }

    public ExamTracking() {

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAnswerScriptId() {
        return answerScriptId;
    }

    public void setAnswerScriptId(String answerScriptId) {
        this.answerScriptId = answerScriptId;
    }

    @Override
    public String toString() {
        return "ExamTracking{" +
                "id=" + id +
                ", student=" + student +
                ", answerScriptId='" + answerScriptId + '\'' +
                '}';
    }
}
