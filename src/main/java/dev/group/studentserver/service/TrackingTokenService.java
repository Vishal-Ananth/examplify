package dev.group.studentserver.service;

import dev.group.studentserver.model.TrackingToken;

import java.util.List;

public interface TrackingTokenService {
    String createTrackingTicket(Integer rollNumber, String subCode, String answerScriptId);

    public List<TrackingToken> getAllTrackingTicket() {
        return trackingTokenRepository.findAll();
    }

    public List<TrackingToken> getTrackingTokenByRollNumber(Integer rollnumber) {
        return trackingTokenRepository.findTrackingTokensByStudents_RollNumber(rollnumber);
    }
}
