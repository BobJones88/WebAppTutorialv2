package com.restTutorial.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "favorites")
public class Favorites {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "favoritesId")
	private Long favoritesId;
	
	@Column(name = "recipeId")
	private Long recipeId;
	
	@Column(name = "userId")
	private Long userId;
	

    @Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp
    @Column(name = "createdTimestamp", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
//  @UpdateTimestamp
    @Column(name = "updatedTimestamp", nullable = false)
    private Date updated;
	
	public Favorites(){}

	public Favorites(Long recipeID, Long userId){
		this.recipeId = recipeID;
		this.userId = userId;
	}
	
	public Long getRecipeId(){ return this.recipeId; }
	public void setRecipeId(Long id) { this.recipeId = id; }
	
	public Long getUserId() { return this.userId; }
	public void setUserId(Long userId) { this.userId = userId; }
	
	public Long getFavoritesId() { return this.favoritesId; }
	public void setFavoritesId(Long favoritesId) { this.favoritesId = favoritesId; }
	
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }

	public Date getUpdated() { return updated;}
	public void setUpdated(Date updated) { this.updated = updated;}
}
