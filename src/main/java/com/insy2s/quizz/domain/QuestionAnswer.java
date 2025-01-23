package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Question is mandatory.")
    @ManyToOne
    private Question question;

    @NotNull(message = "Answer is mandatory.")
    @ManyToOne
    private Answer answer;

    @Column(nullable = false)
    @NotNull(message = "Answer value is mandatory.")
    private boolean isCorrect;
}
