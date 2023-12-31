package dev.group.studentserver.dao;

import dev.group.studentserver.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByRollNumber(Integer rollNumber);
}
