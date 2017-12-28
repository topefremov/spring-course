package org.efremov.hibernatedemo.dao;

import java.util.List;

import org.efremov.hibernatedemo.entities.Singer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("singerDao")
@Transactional
public class SingerDaoImpl implements SingerDao {
	
	SessionFactory sessionFactory;

	@Autowired
	public SingerDaoImpl(SessionFactory sesstionFactory) {
		super();
		this.sessionFactory = sesstionFactory;
	}
	
	public SessionFactory getSesstionFactory() {
		return sessionFactory;
	}

	public void setSesstionFactory(SessionFactory sesstionFactory) {
		this.sessionFactory = sesstionFactory;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Singer s", Singer.class).list();
	}

}
