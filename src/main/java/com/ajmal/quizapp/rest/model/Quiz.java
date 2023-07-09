package com.ajmal.quizapp.rest.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;

@Entity
public class Quiz 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  
  @ManyToMany
  private List<Question> question;
  
  public Quiz() {}

  public Quiz(Integer id, String title, List<Question> question) 
  {
	super();
	this.id = id;
	this.title = title;
	this.question = question;
  }

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public List<Question> getQuestion() {
	return question;
}

public void setQuestion(List<Question> question) {
	this.question = question;
}

@Override
public int hashCode() {
	return Objects.hash(id, question, title);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Quiz other = (Quiz) obj;
	return Objects.equals(id, other.id) && Objects.equals(question, other.question)
			&& Objects.equals(title, other.title);
}

@Override
public String toString() {
	return "Quiz [id=" + id + ", title=" + title + ", question=" + question + "]";
}
  
  
  
  
}
