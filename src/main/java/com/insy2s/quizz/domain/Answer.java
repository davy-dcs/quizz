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
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID uuid;

    @NotBlank(message = "Answer is mandatory.")
    private String value;

    @OneToMany(mappedBy = "answer")
    private List<QuestionAnswer> questions = new ArrayList<>();
}
