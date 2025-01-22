package com.insy2s.quizz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class SessionPlayerKey {

    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "player_id")
    private Long playerId;
}
