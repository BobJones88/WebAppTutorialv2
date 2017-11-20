package com.restTutorial.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.restTutorial.dao.RecipeDao;
import com.restTutorial.models.Recipe;


@Repository("recipeDao")
public class RecipeDaoImpl extends HibernateDaoImpl<Recipe, Long> implements RecipeDao {

	
	public RecipeDaoImpl() { super(Recipe.class); }

	@SuppressWarnings("unchecked")
	public List<Recipe> searchForRecipeByName(String name) {
		Session session = getSessionFactory().getCurrentSession();
		
		String recipeQuery = "FROM Recipe u WHERE (u.recipeName LIKE :recipeName)";
		Query query = session.createQuery(recipeQuery);
		query.setString("recipeName", "%"+name+"%");
		List<Recipe> recipesResult = query.list();
		
		return recipesResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> searchForRecipeByTags(String name) {
		Session session = getSessionFactory().getCurrentSession();
		
		String tagQuery = "FROM Recipe r join fetch r.tags rt where (rt.tagName LIKE :tagName)";
		Query query = session.createQuery(tagQuery);
		query.setString("tagName", "%"+name+"%");
		query.setMaxResults(5);
		List<Recipe> recipesResult = query.list();
		
		return recipesResult;
	}
	
}
