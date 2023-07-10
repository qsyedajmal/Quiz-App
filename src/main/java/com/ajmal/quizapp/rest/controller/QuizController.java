package com.ajmal.quizapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajmal.quizapp.rest.model.Answer;
import com.ajmal.quizapp.rest.model.Question;
import com.ajmal.quizapp.rest.model.QuizQuestion;
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
	
	@GetMapping("/quiz/{quiz_id}")
	public ResponseEntity<List<QuizQuestion>> getQuiz(@PathVariable Integer quiz_id)
	{
		return quizService.getQuizQuestions(quiz_id);
		
	}

	@PostMapping("/quiz/{quiz_id}")
	public ResponseEntity<String> submitQuiz(@PathVariable Integer quiz_id, @RequestBody List<Answer> answer)
	{
		return quizService.calculateResult(quiz_id,answer);
	}
}
