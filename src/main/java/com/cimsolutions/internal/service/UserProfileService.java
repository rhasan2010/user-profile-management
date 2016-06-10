package com.cimsolutions.internal.service;

import java.util.List;

import com.cimsolutions.internal.model.UserProfile;

public interface UserProfileService {
	
	UserProfile findById(int id);

	UserProfile findByType(String type);

	List<UserProfile> findAll();
}
