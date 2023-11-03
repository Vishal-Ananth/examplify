package dev.group.studentserver.dao;

import dev.group.studentserver.model.ExamTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTrackingRepository extends JpaRepository<ExamTracking,Integer> {
}
