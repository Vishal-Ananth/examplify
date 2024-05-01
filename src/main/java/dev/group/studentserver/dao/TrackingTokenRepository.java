package dev.group.studentserver.dao;

import dev.group.studentserver.model.TrackingToken;
import org.antlr.v4.runtime.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingTokenRepository extends JpaRepository<TrackingToken,String> {

    List<TrackingToken> findTrackingTokensByStudents_RollNumber(Integer rollnumber);
}
