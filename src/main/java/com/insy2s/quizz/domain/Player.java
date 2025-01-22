package com.insy2s.quizz.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Player {
    @Id
    private Long id;

    @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    private String name;

    @OneToMany(mappedBy = "player")
    private List<SessionPlayer> sessionPlayerList = new ArrayList<>();
}
