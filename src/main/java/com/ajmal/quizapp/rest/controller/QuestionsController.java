package com.ajmal.quizapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajmal.quizapp.rest.model.Question;
import com.ajmal.quizapp.rest.service.QuestionsService;

@RestController
@RequestMapping("/question")
public class QuestionsController {
	
	@Autowired
	QuestionsService questionsService;
	
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions()
	{
		return questionsService.getAllQuestions();
	}

}
