package com.insy2s.quizz.controller;

import com.insy2s.quizz.domain.Question;
import com.insy2s.quizz.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllQuestions());
    }

    @PostMapping
    public ResponseEntity<Void> post(@Valid @RequestBody Question question) {
        questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
