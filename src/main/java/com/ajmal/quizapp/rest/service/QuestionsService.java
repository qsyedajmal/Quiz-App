package com.ajmal.quizapp.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmal.quizapp.rest.dao.QuestionsDAO;
import com.ajmal.quizapp.rest.model.Question;



@Service
public class QuestionsService {
    
	@Autowired
	QuestionsDAO questionsDAO;
	
	public List<Question> getAllQuestions() {
		return questionsDAO.findAll();
		
	}

}
 