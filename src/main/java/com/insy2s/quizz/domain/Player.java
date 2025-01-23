package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    @EqualsAndHashCode.Exclude
    private UUID uuid;

    @NotBlank(message = "Name is mandatory.")
    private String name;

    @OneToMany(mappedBy = "player")
    private List<SessionPlayer> sessionPlayerList = new ArrayList<>();
}
