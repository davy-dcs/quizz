package com.insy2s.quizz.controller;

import com.insy2s.quizz.domain.QuestionAnswer;
import com.insy2s.quizz.dto.DtoQuestionAnswerByIdPost;
import com.insy2s.quizz.service.QuestionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/questions-answers")
public class QuestionAnswerController {
    private final QuestionAnswerService questionAnswerService;

    @GetMapping
    public ResponseEntity<List<QuestionAnswer>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(questionAnswerService.getAllQuestionsAnswers());
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody DtoQuestionAnswerByIdPost dtoQuestionAnswerByIdPost) {
        questionAnswerService.postQuestionAnswer(dtoQuestionAnswerByIdPost);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
