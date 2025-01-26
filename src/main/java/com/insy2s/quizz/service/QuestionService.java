package com.insy2s.quizz.service;

import com.insy2s.quizz.domain.Question;
import com.insy2s.quizz.dto.question.QuestionValueCategoriesDifficultyDto;
import com.insy2s.quizz.dto.question.QuestionValueDto;
import com.insy2s.quizz.dto.question.QuestionWholeDto;
import com.insy2s.quizz.exception.QuestionAlreadyExistException;
import com.insy2s.quizz.exception.QuestionNotFoundException;
import com.insy2s.quizz.repository.IQuestionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final IQuestionRepository questionRepository;

    public List<QuestionWholeDto> getQuestions() {
        List<QuestionWholeDto> questions = new ArrayList<>();
        for (Question question : questionRepository.findAll()) {
            questions.add(new QuestionWholeDto(
                    question.getUuid(),
                    question.getValue(),
                    question.getCategories(),
                    question.getDifficulty()
            ));
        }
        return questions;
    }

    public List<QuestionValueDto> getQuestionsValues() {
        List<QuestionValueDto> values = new ArrayList<>();
        for (Question question : questionRepository.findAll()) {
            values.add(new QuestionValueDto(question.getValue()));
        }
        return values;
    }

    private Question getById(UUID question) {
        Optional<Question> questionOptional = questionRepository.findById(question);
        if (questionOptional.isPresent()) {
            return questionOptional.get();
        }
        throw new QuestionNotFoundException("Question not found.");
    }

    public void postQuestion(QuestionValueCategoriesDifficultyDto questionValueCategoriesDifficultyDto) {
        Question question = new Question();
        question.setValue(questionValueCategoriesDifficultyDto.getValue());
        question.setCategories(questionValueCategoriesDifficultyDto.getCategories());
        question.setDifficulty(questionValueCategoriesDifficultyDto.getDifficulty());
        this.createQuestion(question);
    }

    private void createQuestion(@Valid Question question) {
        Optional<Question> questionOptional = questionRepository.findByValueIgnoreCase(question.getValue());
        questionOptional.ifPresentOrElse(
                exist -> {throw new QuestionAlreadyExistException("Question already exist.");},
                () -> questionRepository.save(question)
        );
    }

    public void updateQuestion(UUID question, QuestionValueCategoriesDifficultyDto questionPut) {
        Question questionToUpdate = this.getById(question);
        try {
            if (questionPut.getValue() != null) {
                questionToUpdate.setValue(questionPut.getValue());
            }
            if (questionPut.getCategories() != null) {
                questionToUpdate.setCategories(questionPut.getCategories());
            }
            if (questionPut.getDifficulty() != null) {
                questionToUpdate.setDifficulty(questionPut.getDifficulty());
            }
            questionRepository.save(questionToUpdate);
        } catch (Exception e) {
            throw new QuestionAlreadyExistException("Question already exist.");
        }
    }

    public void deleteQuestion(UUID question) {
        questionRepository.delete(this.getById(question));
    }
}
