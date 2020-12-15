package fr.formation.training.forum.services;

import javax.validation.Valid;

import fr.formation.training.forum.dtos.AnswerCreateDto;
import fr.formation.training.forum.dtos.AnswerPatchDto;
import fr.formation.training.forum.dtos.IdentifierDto;

public interface AnswerService {

    IdentifierDto create(@Valid AnswerCreateDto dto);

    void update(Long id, AnswerPatchDto dto);
}
