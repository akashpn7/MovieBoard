package com.deep.mb.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deep.mb.entity.Movie;

@Service
public class MovieDAOImpl {

	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	public MovieDAOImpl(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionfactory = factory.unwrap(SessionFactory.class);
	}

	public void setHibernateTemplate(SessionFactory hibernateFactory) {
		this.sessionfactory = hibernateFactory;
	}
	
	public List<Movie> getMovieByTConst(String searchVal){
	
		Session session = sessionfactory.openSession();
		String hql = "FROM Movie M WHERE M.tconst in ("+searchVal+")";
		System.out.println(hql);
		Query<Movie> query = session.createQuery(hql);
		List<Movie> movieList = query.list();
		session.close();
		return movieList;
	}
	
}
