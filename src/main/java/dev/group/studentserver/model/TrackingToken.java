package dev.group.studentserver.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingToken {

    @Id
    private String answerScriptId;
    @ManyToOne
    private Student students;
    @ManyToOne
    private Subject subject;
    @Column(name = "exam_date")
    LocalDate examDate = java.time.LocalDate.now();
    @Column(name = "attendance_time")
    LocalTime attendanceTime = java.time.LocalTime.now();

    public TrackingToken(String answerScriptId, Student students, Subject subject) {
        this.answerScriptId = answerScriptId;
        this.students = students;
        this.subject = subject;
    }
}
