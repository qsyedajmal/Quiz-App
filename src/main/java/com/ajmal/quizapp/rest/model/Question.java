package com.ajmal.quizapp.rest.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "question")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class Question {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Integer id;
	private String category;
	private String difficultyLevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questionTitle;
	private String rightAnswer;
	
	
	public Question() {}
	
	
	
	public Question(Integer id, String category, String difficultyLevel, String option1, String option2, String option3,
			String option4, String questionTitle, String rightAnswer) {
		super();
		this.id = id;
		this.category = category;
		this.difficultyLevel = difficultyLevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionTitle = questionTitle;
		this.rightAnswer = rightAnswer;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDifficultyLevel() {
		return difficultyLevel;
	}



	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}



	public String getOption1() {
		return option1;
	}



	public void setOption1(String option1) {
		this.option1 = option1;
	}



	public String getOption2() {
		return option2;
	}



	public void setOption2(String option2) {
		this.option2 = option2;
	}



	public String getOption3() {
		return option3;
	}



	public void setOption3(String option3) {
		this.option3 = option3;
	}



	public String getOption4() {
		return option4;
	}



	public void setOption4(String option4) {
		this.option4 = option4;
	}



	public String getQuestionTitle() {
		return questionTitle;
	}



	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}



	public String getRightAnswer() {
		return rightAnswer;
	}



	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}



	@Override
	public int hashCode() {
		return Objects.hash(category, difficultyLevel, id, option1, option2, option3, option4, questionTitle,
				rightAnswer);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(category, other.category) && Objects.equals(difficultyLevel, other.difficultyLevel)
				&& Objects.equals(id, other.id) && Objects.equals(option1, other.option1)
				&& Objects.equals(option2, other.option2) && Objects.equals(option3, other.option3)
				&& Objects.equals(option4, other.option4) && Objects.equals(questionTitle, other.questionTitle)
				&& Objects.equals(rightAnswer, other.rightAnswer);
	}
	
    
}
