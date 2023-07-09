package com.ajmal.quizapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajmal.quizapp.rest.model.Question;
import com.ajmal.quizapp.rest.service.QuestionsService;

@RestController
//@RequestMapping("/question")
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	@GetMapping("/question")
	@ResponseBody
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionsService.getAllQuestions();
	}
	
	@GetMapping("/question/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{    
		
		return questionsService.getQuestionsByCategory(category);
	}
	
	@PostMapping("/question")
	public  ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return questionsService.addQuestion(question);
	}

}
