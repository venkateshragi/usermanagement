package com.challenge.usermanagement.dao.hsql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.challenge.usermanagement.dao.UserDao;
import com.challenge.usermanagement.domain.User;

/**
 * Created by venkateshr on 31/7/16.
 */
@Repository("userDao")
public class UserDaoHSQL implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public long saveUser(User user) {
		return (Long) getSession().save(user);
	}
	
	public void updateUser(User user) {
		this.getSession().update(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return getSession().createQuery("from " + User.class.getName() + " x").list();
	}
	
	public User findUserById(long id) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("uuid", id));
		return (User) criteria.uniqueResult();
	}	
}
