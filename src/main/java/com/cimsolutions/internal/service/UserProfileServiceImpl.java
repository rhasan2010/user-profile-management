package com.cimsolutions.internal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimsolutions.internal.dao.UserProfileDao;
import com.cimsolutions.internal.model.UserProfile;

<<<<<<< HEAD
@Service("UserProfileService")
=======
@Service("userProfileService")
>>>>>>> a615019ee2152c6b2bc4f5f7944aedca6935f245
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao userProfileDao;

	@Override
	public UserProfile findById(int id) {
		return userProfileDao.findById(id);
	}

	@Override
	public UserProfile findByType(String type) {
		return userProfileDao.findByType(type);
	}

	@Override
	public List<UserProfile> findAll() {
		return userProfileDao.findAll();
	}

}
