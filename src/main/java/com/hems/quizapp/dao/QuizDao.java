package com.hems.quizapp.dao;

import com.hems.quizapp.model.Question;
import com.hems.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
