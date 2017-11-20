package com.restTutorial.services;

import java.util.List;

import com.restTutorial.models.Favorites;
import com.restTutorial.models.Saved;
import com.restTutorial.models.User;

public interface UserManager extends GenericManager<User, Long> {
	User getUserById(Long id);
	List<User> searchForUserByName(String name);
	
	Favorites getFavorites(Long userId);
	List<Favorites> searchForUserFavorites(Long filter);
		
	List<Saved> searchForUserSaved(Long filter);
	
}