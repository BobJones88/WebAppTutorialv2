package com.restTutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorites extends Timestamp {
	
	@Id
	@Column(name = "recipeId")
	private Long recipeId;
	
	@Column(name = "userId")
	private Long userId;
	
	public Favorites(){}
	
	public Favorites(Long recipeID, Long userId){
		this.recipeId = recipeID;
		this.userId = userId;
	}
	
	public Long getRecipeId(){ return this.recipeId; }
	public void setRecipeId(Long id) { this.recipeId = id; }
	
	public Long getUserId() { return this.userId; }
	public void setUserId(Long userId) { this.userId = userId; }
}
