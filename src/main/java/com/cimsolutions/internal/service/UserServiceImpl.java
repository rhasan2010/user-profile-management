package com.cimsolutions.internal.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimsolutions.internal.dao.UserDao;
import com.cimsolutions.internal.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// private PasswordEncode

	@Override
	public User findById(int id) {
		User user = userDao.findById(id);
		return user;
	}

	@Override
	public User findBySSO(String sso) {
		User user = userDao.findBySSO(sso);
		return user;
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		User entity = userDao.findById(user.getId());

		if (entity != null) {
			entity.setSsoId(user.getSsoId());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
		}
	}

	@Override
	public void deleteUserBySSO(String sso) {
		userDao.deleteBySSO(sso);

	}

	@Override
	public List<User> findAllUsers() {
		List<User> userList = userDao.findAllUsers();
		return userList;
	}

	@Override
	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

}
