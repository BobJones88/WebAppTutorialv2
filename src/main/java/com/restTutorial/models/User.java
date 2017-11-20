package com.restTutorial.models;

import java.util.HashSet;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName", length = 45)
	private String firstName;
	
	@Column(name = "lastName", length = 45)
	private String lastName;
	
	@Column(name = "userName", length = 45)
	private String userName;
	
	@Column(name = "password", length = 45)
	private String password;
	
	@Column(name = "profilePicture", length = 45)
	private String profilePicture;
	
	@Column(name = "handle", length = 45)
	private String handle;
	
	@Column(name = "email", length = 45)
	private String email;
	
	@OneToMany(targetEntity = Favorites.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "userID")
	@Cascade(value = {CascadeType.ALL})
	private Set<Favorites> favorites;
	
	public User(){}
	
	public User(Long id, String firstName, String lastName, String userName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId(){ return this.id; }
	public void setId(Long id) { this.id = id; }
	
	public String getFirstName() { return this.firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return this.lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getUserName() { return this.userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getProfilePicture() { return this.profilePicture; }
	public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
	
	public String getHandle() { return this.handle; }
	public void setHandle(String handle) { this.handle = handle; }
	
	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	
	public Set<Favorites> getFavorites() { 
		if (favorites == null) {			
			favorites = new HashSet();			
		}
		return this.favorites; 
	
	}
	
	
}
