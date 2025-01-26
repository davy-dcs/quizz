package com.insy2s.quizz.dto.question;

import com.insy2s.quizz.domain.Category;
import com.insy2s.quizz.domain.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class QuestionValueCategoriesDifficultyDto {
    private String value;
    private List<Category> categories;
    private Difficulty difficulty;
}
