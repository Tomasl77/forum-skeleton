package fr.formation.training.forum.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.training.forum.dtos.AnswerCreateDto;
import fr.formation.training.forum.dtos.AnswerPatchDto;
import fr.formation.training.forum.dtos.IdentifierDto;
import fr.formation.training.forum.services.AnswerService;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
	this.answerService = answerService;
    }

    @PostMapping
    public IdentifierDto create(@Valid @RequestBody AnswerCreateDto dto) {
	return answerService.create(dto);
    }

    @PatchMapping("/{id}")
    public void patch(@PathVariable("id") Long id,
            @Valid @RequestBody AnswerPatchDto dto) {
	answerService.update(id, dto);
    }
}
