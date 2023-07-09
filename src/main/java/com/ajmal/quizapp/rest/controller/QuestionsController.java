package com.ajmal.quizapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/question")
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	@GetMapping("/allquestions")
	@ResponseBody
	public List<Question> getAllQuestions()
	{
		return questionsService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category)
	{   
		
		return questionsService.getQuestionsByCategory(category);
	}
	
	@PostMapping("/addquestion")
	public String addQuestion(@RequestBody Question question) {
		return questionsService.addQuestion(question);
	}

}
