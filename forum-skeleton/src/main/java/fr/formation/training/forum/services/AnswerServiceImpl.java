package fr.formation.training.forum.services;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.formation.training.forum.dtos.AnswerCreateDto;
import fr.formation.training.forum.dtos.AnswerPatchDto;
import fr.formation.training.forum.dtos.IdentifierDto;
import fr.formation.training.forum.entities.Answer;
import fr.formation.training.forum.repositories.AnswerRepository;
import fr.formation.training.forum.repositories.QuestionJpaRepository;

@Service
public class AnswerServiceImpl extends AbstractService
        implements AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionJpaRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository,
            QuestionJpaRepository questionRepository) {
	this.answerRepository = answerRepository;
	this.questionRepository = questionRepository;
    }

    @Override
    public IdentifierDto create(@Valid AnswerCreateDto dto) {
	Answer answer = getMapper().map(dto, Answer.class);
	answer.setQuestion(questionRepository.getOne(dto.getQuestionId()));
	answer.setAnswerDate(LocalDateTime.now());
	answerRepository.save(answer);
	return new IdentifierDto(answer.getId());
    }

    @Override
    public void update(Long id, AnswerPatchDto dto) {
	Answer answer = answerRepository.findById(id).get();
	getMapper().map(dto, answer);
	answerRepository.save(answer);
    }
}
