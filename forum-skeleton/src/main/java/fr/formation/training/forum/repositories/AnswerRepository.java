package fr.formation.training.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.training.forum.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
