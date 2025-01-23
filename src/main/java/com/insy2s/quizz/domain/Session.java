package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID uuid;

    @NotNull(message = "Mode is mandatory.")
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @NotNull(message = "Quiz is mandatory.")
    @ManyToOne
    private Quiz quiz;

    @Positive
    private int timer;

    @FutureOrPresent(message = "Date must be future or present")
    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "session")
    private List<SessionPlayer> sessionPlayerList = new ArrayList<>();
}
