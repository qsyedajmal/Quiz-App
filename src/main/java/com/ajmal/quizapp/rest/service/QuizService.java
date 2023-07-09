package com.ajmal.quizapp.rest.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajmal.quizapp.rest.dao.QuestionsDAO;
import com.ajmal.quizapp.rest.dao.QuizDAO;
import com.ajmal.quizapp.rest.model.Question;
import com.ajmal.quizapp.rest.model.Quiz;

@Service
public class QuizService {
	
	@Autowired
	private QuizDAO quizDAO;
	@Autowired
	private QuestionsDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, String numofques, String title) 
	{
		
		try 
		{
			BigInteger numofquesint = new BigInteger(numofques);
			
			List<Question> questions = questionDAO.findRandomQuestionsByCategory(category,numofquesint);

			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestion(questions);
			
			quizDAO.save(quiz);
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}
		catch (Exception e) 
		{
			System.out.println("Cant able to create quiz");
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}
