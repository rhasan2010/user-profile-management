package com.cimsolutions.internal.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cimsolutions.internal.model.User;
import com.cimsolutions.internal.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	UserService userService;
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> userList = userService.findAllUsers();
		model.addAttribute("users", userList);

		return "userslist";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String newUser(ModelMap model) {
		User user = new User();

		model.addAttribute("user", user);
		model.addAttribute("edit", false);

		return "registration";
	}

	@RequestMapping(value = { "/adduser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
			FieldError ssoErro = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId",
					new String[] { user.getSsoId() }, Locale.getDefault()));
			result.addError(ssoErro);
		}

		userService.saveUser(user);

		model.addAttribute("Success",
				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
		return "registrationsuccess";
	}

}
