package com.cimsolutions.internal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import com.cimsolutions.internal.model.UserProfile;

@Repository("UserProfileDao")
=======

import com.cimsolutions.internal.model.UserProfile;

>>>>>>> a615019ee2152c6b2bc4f5f7944aedca6935f245
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {

	@Override
	public List<UserProfile> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UserProfile>) crit.list();

	}

	@Override
	public UserProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (UserProfile) crit.uniqueResult();
	}

	@Override
	public UserProfile findById(int id) {
		return getByKey(id);
	}

}
