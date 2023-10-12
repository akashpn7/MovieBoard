package com.deep.mb.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deep.mb.entity.Actor;

@Service
public class ActorDAOImpl {

	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	public ActorDAOImpl(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionfactory = factory.unwrap(SessionFactory.class);
	}

	public void setHibernateTemplate(SessionFactory hibernateFactory) {
		this.sessionfactory = hibernateFactory;
	}

	public List<Actor> getActorByName(String searchVal) {

		Session session = sessionfactory.openSession();
		String hql = "FROM Actor A WHERE A.primaryName LIKE :search_value";
		System.out.println(hql);
		Query<Actor> query = session.createQuery(hql);
		query.setParameter("search_value", "%" + searchVal + "%");
		List<Actor> actorList = query.list();
		session.close();
		return actorList;
	}

	public List<Actor> getActorByNconst(String nconst) {

		Session session = sessionfactory.openSession();
		String hql = "FROM Actor A WHERE A.nconst=:search_value";
		System.out.println(hql);
		Query<Actor> query = session.createQuery(hql);
		query.setParameter("search_value", nconst);
		List<Actor> actorList = query.list();
		session.close();
		return actorList;
	}

}
