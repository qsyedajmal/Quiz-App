package com.ajmal.quizapp.rest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajmal.quizapp.rest.model.Question;

@Repository
public interface QuestionsDAO extends JpaRepository<Question, Integer>{
	
	List<Question> findByCategory(String category);


}
