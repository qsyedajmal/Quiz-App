package com.ajmal.quizapp.rest.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ajmal.quizapp.rest.dao.QuestionsDAO;
import com.ajmal.quizapp.rest.model.Question;



@Service
public class QuestionsService {
    
	@Autowired
	private QuestionsDAO questionsDAO;
	
	
	
	public ResponseEntity<List<Question>> getAllQuestions() 
	{
		try 
		{
			return new ResponseEntity<>(questionsDAO.findAll(),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			System.out.println("Not able to find all questions");
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

	
	
	
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		try 
		{
			return new ResponseEntity<>(questionsDAO.findByCategory(category),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			System.out.println("Not able to find all questions by category");
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
	}

	
	
	
	
	
	public ResponseEntity<Question>  addQuestion(Question question) {
		
		Question q = questionsDAO.save(question);
		
		try 
		{
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(q.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
		}
		catch (Exception e) {
			System.out.println("Not able to add question");
		}
		
		return ResponseEntity.badRequest().build();
	}

}
 