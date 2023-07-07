package com.ajmal.quizapp.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuedtionsController {
	
	@GetMapping("/allQuestions")
	public String getAllQuestions()
	{
		return "TEST";
	}

}
