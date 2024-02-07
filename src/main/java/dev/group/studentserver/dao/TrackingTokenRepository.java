package dev.group.studentserver.dao;

import dev.group.studentserver.model.TrackingToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingTokenRepository extends JpaRepository<TrackingToken,String> {
}
