package com.restTutorial.dao;

import java.util.List;

import com.restTutorial.models.Favorites;
import com.restTutorial.models.Saved;
import com.restTutorial.models.User;

public interface UserDao extends GenericDao<User, Long>{
	List<User> searchForUserByName(String name);
	List<Favorites> searchForUserFavorites(Long userId);
	List<Saved> searchForUserSaved(Long userId);
}
