package fr.formation.training.forum.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AnswerPatchDto {

    @NotBlank
    @Size(max = 1000)
    private String text;

    public String getText() {
	return text;
    }
}
