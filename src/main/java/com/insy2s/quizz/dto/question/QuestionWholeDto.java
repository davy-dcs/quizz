package com.insy2s.quizz.dto.question;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.domain.Category;
import com.insy2s.quizz.domain.Difficulty;
import com.insy2s.quizz.domain.QuestionAnswer;
import com.insy2s.quizz.dto.answer.AnswerValueDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class QuestionWholeDto {
    private UUID uuid;
    private String value;
    private List<Category> categories;
    private Difficulty difficulty;
}
