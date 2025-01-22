package com.insy2s.quizz.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Session {

    @Id
    private Long id;

    @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    @Enumerated(EnumType.STRING)
    private Mode mode;

    @ManyToOne
    private Quizz quizz;


    private int timer;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "session")
    private List<SessionPlayer> sessionPlayerList = new ArrayList<>();
}
