package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private Mode mode;

    @ManyToOne
    private Quizz quizz;

    @Setter
    private int timer;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "session")
    private List<SessionPlayer> sessionPlayerList = new ArrayList<>();
}
