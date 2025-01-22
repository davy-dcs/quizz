package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class SessionPlayer {

    @Id
    @ManyToOne
    private Session session;

    @Id
    @ManyToOne
    private Player player;

    private int score;
}
