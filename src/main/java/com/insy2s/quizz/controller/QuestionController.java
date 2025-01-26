package com.insy2s.quizz.controller;

import com.insy2s.quizz.dto.question.QuestionValueCategoriesDifficultyDto;
import com.insy2s.quizz.dto.question.QuestionValueDto;
import com.insy2s.quizz.dto.question.QuestionWholeDto;
import com.insy2s.quizz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
//TODO Uniquement les admins
@RequiredArgsConstructor
@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    /**
     * Get all value's questions
     *
     * @return List of values
     */
    @GetMapping
    public ResponseEntity<List<QuestionValueDto>> getValues() {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsValues());
    }

    /**
     * Get all questions
     *
     * @return List of questions
     */
    @GetMapping("/whole")
    public ResponseEntity<List<QuestionWholeDto>> getQuestions() {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestions());
    }


    /**
     * Create a question by value, categories and difficulty
     *
     * @param questionValueCategoriesDifficultyDto Fields value, categories and difficulty
     * @return Void
     */
    @PostMapping
    public ResponseEntity<Void> postQuestion(@RequestBody QuestionValueCategoriesDifficultyDto questionValueCategoriesDifficultyDto) {
        questionService.postQuestion(questionValueCategoriesDifficultyDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Update question
     *
     * @param question    UUID
     * @param questionPut Data to update
     * @return Void
     */
    @PutMapping("/{question}")
    public ResponseEntity<Void> putQuestion(@PathVariable UUID question, @RequestBody QuestionValueCategoriesDifficultyDto questionPut) {
        questionService.updateQuestion(question, questionPut);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Delete question by id
     *
     * @param question UUID
     * @return Void
     */
    @DeleteMapping("/{question}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable UUID question) {
        questionService.deleteQuestion(question);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
