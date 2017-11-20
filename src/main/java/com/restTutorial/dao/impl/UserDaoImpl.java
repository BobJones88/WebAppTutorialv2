package com.restTutorial.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.restTutorial.dao.UserDao;
import com.restTutorial.models.Favorites;
import com.restTutorial.models.Saved;
import com.restTutorial.models.User;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl<User, Long> implements UserDao {

	
	public UserDaoImpl() { super(User.class); }

	@SuppressWarnings("unchecked")
	public List<User> searchForUserByName(String name) {
		Session session = getSessionFactory().getCurrentSession();
		
		String userQuery = "FROM User u WHERE (u.firstName LIKE :firstName OR u.lastName LIKE :lastName)";
		Query query = session.createQuery(userQuery);
		query.setString("firstName", "%"+name+"%");
		query.setString("lastName", "%"+name+"%");
		List<User> usersResult = query.list();
		
		return usersResult;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Favorites> searchForUserFavorites(Long userId) {
		Session session = getSessionFactory().getCurrentSession();
		
		String favoriteQuery = "FROM Recipe r join fetch r.favorites rf WHERE rf.userId = :userId";
		Query query = session.createQuery(favoriteQuery);
		query.setLong("userId", userId);
		
		List<Favorites> favoritesResult = query.list();
		
		return favoritesResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<Saved> searchForUserSaved(Long userId) {
		Session session = getSessionFactory().getCurrentSession();
		
		String savedQuery = "FROM Recipe r join fetch r.saved rs WHERE rs.userId = :userId";
		Query query = session.createQuery(savedQuery);
		query.setLong("userId", userId);
		
		List<Saved> savedResult = query.list();
		
		return savedResult;
	}
}
