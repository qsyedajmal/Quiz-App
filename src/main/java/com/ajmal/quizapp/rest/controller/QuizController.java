package com.ajmal.quizapp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajmal.quizapp.rest.service.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService; 
	
	@PostMapping("/quiz/create/category/{category}/numofques/{numofques}/title/{title}")
	public ResponseEntity<String> createQuiz(@PathVariable String category,@PathVariable String numofques,@PathVariable String title)
	{
		return quizService.createQuiz(category,numofques,title);
		
	}

}
