package fr.formation.training.forum.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class AnswerCreateDto {

    @NotBlank
    @Size(max = 50)
    private String author;

    @NotBlank
    @Size(max = 1000)
    private String text;

    @NotNull
    @Positive
    private Long questionId;

    public String getAuthor() {
	return author;
    }

    public String getText() {
	return text;
    }

    public Long getQuestionId() {
	return questionId;
    }
}
