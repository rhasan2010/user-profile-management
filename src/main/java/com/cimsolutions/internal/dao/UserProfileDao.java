package com.cimsolutions.internal.dao;

import java.util.List;

import com.cimsolutions.internal.model.UserProfile;

public interface UserProfileDao {
	
	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}
