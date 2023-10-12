package com.deep.mb.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorMovieMappingDAOImpl {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	public ActorMovieMappingDAOImpl(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionfactory = factory.unwrap(SessionFactory.class);
	}

	public void setHibernateTemplate(SessionFactory hibernateFactory) {
		this.sessionfactory = hibernateFactory;
	}
	
	public List getActorMovieData(String searchVal){
	
		Session session = sessionfactory.openSession();
		String hql = "FROM Actor A WHERE A.primaryName LIKE :search_value";
		Query query = session.createQuery(hql);
		query.setParameter("search_value", "%" + searchVal + "%");
		List actorMovieList = query.list();
		session.close();
		return actorMovieList;
	}
	
}
