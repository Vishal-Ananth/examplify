package dev.group.studentserver.dao;

import dev.group.studentserver.model.Student;
import dev.group.studentserver.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByRollNumber(Integer rollNumber);

}
