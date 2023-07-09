package com.ajmal.quizapp.rest.dao;


import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajmal.quizapp.rest.model.Question;

@Repository
public interface QuestionsDAO extends JpaRepository<Question, Integer>{
	
	List<Question> findByCategory(String category);
    
	@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numofquesint",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, BigInteger numofquesint);


}
