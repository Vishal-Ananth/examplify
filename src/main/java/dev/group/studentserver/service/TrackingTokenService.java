package dev.group.studentserver.service;

import dev.group.studentserver.model.TrackingToken;

import java.util.List;

public interface TrackingTokenService {
    String createTrackingTicket(Integer rollNumber, String subCode, String answerScriptId);

    List<TrackingToken> getAllTrackingTicket();
}
