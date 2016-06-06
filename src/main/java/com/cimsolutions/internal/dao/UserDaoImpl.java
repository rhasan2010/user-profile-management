package com.cimsolutions.internal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cimsolutions.internal.model.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public User findById(int id) {
		User user = getByKey(id);

		if (user != null) {

		}
		return user;
	}

	@Override
	public User findBySSO(String sso) {
		logger.info("SSO: {}", sso);

		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));

		User user = (User) crit.uniqueResult();
		if (user != null) {

		}
		return user;
	}

	@Override
	public void save(User user) {
		persist(user);
	}

	@Override
	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));

		User user = (User) crit.uniqueResult();
		delete(user);
	}

	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // Avoid
																		// duplicates
		List<User> userList = (List<User>) criteria.list();
		return userList;
	}

}
