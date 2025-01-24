package com.insy2s.quizz.controller;

import com.insy2s.quizz.domain.QuestionAnswer;
import com.insy2s.quizz.service.QuestionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/question-answer")
public class QuestionAnswerController {
    private final QuestionAnswerService questionAnswerService;

    @GetMapping
    public ResponseEntity<List<QuestionAnswer>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(questionAnswerService.getAllQuestionsAnswers());
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody QuestionAnswer questionAnswer) {
        questionAnswerService.postQuestionAnswer(questionAnswer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
