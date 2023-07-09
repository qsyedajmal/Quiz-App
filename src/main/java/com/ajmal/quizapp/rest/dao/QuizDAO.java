package com.ajmal.quizapp.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajmal.quizapp.rest.model.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer>{

}
