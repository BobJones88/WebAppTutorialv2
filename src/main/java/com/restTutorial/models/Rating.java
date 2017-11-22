package com.restTutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "recipeId")
	private Long recipeId;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "userRating")
	private Long userRating;
	
	public Rating(){}
	
	public Rating(Long recipeID, Long userId){
		this.recipeId = recipeID;
		this.userId = userId;
	}
	
	public Long getRecipeId(){ return this.recipeId; }
	public void setRecipeId(Long id) { this.recipeId = id; }
	
	public Long getUserId() { return this.userId; }
	public void setUserId(Long userId) { this.userId = userId; }
	
	public Long getUserRating() { return this.userRating; }
	public void setUserRating(Long userRating) { this.userRating = userRating; }
}
