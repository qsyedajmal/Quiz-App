package com.ajmal.quizapp.rest.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajmal.quizapp.rest.dao.QuestionsDAO;
import com.ajmal.quizapp.rest.dao.QuizDAO;
import com.ajmal.quizapp.rest.model.Answer;
import com.ajmal.quizapp.rest.model.Question;
import com.ajmal.quizapp.rest.model.Quiz;
import com.ajmal.quizapp.rest.model.QuizQuestion;

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

	public ResponseEntity<List<QuizQuestion>> getQuizQuestions(Integer quiz_id) {
		
		Quiz quiz = quizDAO.findById(quiz_id).orElse(null);
		
		List<Question> questionFromQuiz = quiz.getQuestion();
		
		List<QuizQuestion> questionToUser = new ArrayList<>();
		
		for(Question q : questionFromQuiz)
		{
			QuizQuestion qq = new QuizQuestion(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionToUser.add(qq);
		}
		
		return new ResponseEntity<>(questionToUser,HttpStatus.OK);
	}

	public ResponseEntity<String> calculateResult(Integer quiz_id, List<Answer> answer) {
		
		Quiz quiz = quizDAO.findById(quiz_id).orElse(null);
		
		List<Question> question = quiz.getQuestion();
		
		int score =0;
		int i=0;
		
		for(Answer a : answer)
		{
			while (i<question.size())
			{
				if(a.getId().equals(question.get(i).getId()))
				{
					if(a.getAnswer().equals(question.get(i).getRightAnswer()))
					{
						score++;
					}
				}
				i++;
			}
			i=0;
		}
		
		return new ResponseEntity<>("The score is "+score, HttpStatus.OK);
	}

}
