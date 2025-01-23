package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class SessionPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Session is mandatory.")
    @ManyToOne
    private Session session;

    @NotNull(message = "Player is mandatory.")
    @ManyToOne
    private Player player;

    @Min(0)
    @Max(100)
    private double score;
}
