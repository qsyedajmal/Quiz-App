package com.ajmal.quizapp.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
	
	@PostMapping("/quiz/create/category/{category}/numofques/{numofques}/title/{title}")
	public ResponseEntity<String> createQuiz(@PathVariable String category,@PathVariable String numofques,@PathVariable String title)
	{
		return new ResponseEntity<>("Test",HttpStatus.OK);
		
	}

}
