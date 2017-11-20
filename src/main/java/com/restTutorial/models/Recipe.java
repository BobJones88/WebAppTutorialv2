package com.restTutorial.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "recipeName", length = 45)
	private String recipeName;
	
	@Column(name = "description", length = 45)
	private String recipeDescription;
	
	@Column(name = "prepTime")
	private Long prepTime;
	
	@Column(name = "cookTime")
	private Long cookTime;
	
	@Column(name = "servings")
	private Long servings;
	
	@Column(name = "image", length = 45)
	private String recipeImage;
	
	@Column(name = "instructions", length = 45)
	private String recipeInstructions;
	
	@Column(name = "ingredients", length = 45)
	private String recipeIngredients;
	
	@OneToMany(targetEntity = Tags.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "recipeID")
	@Cascade(value = {CascadeType.ALL})
	@JsonIgnore
	private Set<Tags> tags;
	
	@Transient
	public List<String> getTagNames(){
		List<String> tagNames = new ArrayList<String>();
		
		if (getTags() != null) {
			for (Tags tag : getTags() ) {
				tagNames.add(tag.getTagName());
			}
		}
		return tagNames;
	}
	
	@OneToMany( /* targetEntity = Review.class, */ fetch=FetchType.EAGER)
	@JoinColumn(name = "recipeID")
//	@Cascade(value = {CascadeType.ALL})
	private Set<Review> reviews;
	
	@OneToMany( /* targetEntity = Favorites.class, */ fetch=FetchType.EAGER)
	@JoinColumn(name = "recipeID")
	@Cascade(value = {CascadeType.ALL})
	private Set<Favorites> favorites;

	@OneToMany( /* targetEntity = Favorites.class, */ fetch=FetchType.EAGER)
	@JoinColumn(name = "recipeID")
	@Cascade(value = {CascadeType.ALL})
	private Set<Saved> saved;
	
	public Recipe(){}
	
	public Recipe(Long id, String recipeName, Set<Tags> tags, String recipeDescription){
		this.id = id;
		this.recipeName = recipeName;
		this.tags = tags;
		this.recipeDescription = recipeDescription;
	}
	
	public Long getId(){ return this.id; }
	public void setId(Long id) { this.id = id; }
	
	public String getRecipeName() { return this.recipeName; }
	public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
	
	public Set<Tags> getTags() { return this.tags; }
	public void setTags(Set<Tags> tags) { this.tags = tags; }
	
	public Set<Review> getReviews() { return this.reviews; }
	public void setReviews(Set<Review> reviews) { this.reviews = reviews; }
	
	public String getRecipeDescription() { return this.recipeDescription; }
	public void setRecipeDescription(String recipeDescription) { this.recipeDescription = recipeDescription; }
	
	public Long getPrepTime(){ return this.prepTime; }
	public void setPrepTime(Long prepTime) { this.prepTime = prepTime; }
	
	public Long getCookTime(){ return this.cookTime; }
	public void setCookTime(Long cookTime) { this.cookTime = cookTime; }
	
	public Long getServings(){ return this.servings; }
	public void setServings(Long servings) { this.servings = servings; }
	
	public String getRecipeImage() { return this.recipeImage; }
	public void setRecipeImage(String recipeImage) { this.recipeImage = recipeImage; }
	
	public String getRecipeInstructions() { return this.recipeInstructions; }
	public void setRecipeInstructions(String recipeInstructions) { this.recipeInstructions = recipeInstructions; }
	
	public String getRecipeIngredients() { return this.recipeIngredients; }
	public void setRecipeIngredients(String recipeIngredients) { this.recipeIngredients = recipeIngredients; }
}
