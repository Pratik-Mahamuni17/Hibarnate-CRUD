package com.main;

import com.dao.UserDao;
import com.entity.User;

public class App {

	public static void main(String[] args) {
		
		User user = new User();
		user.setName("Chaitanya");
		user.setCity("Koregaon");
		user.setEmail("Chaitanya@gmail.com");
		user.setPassword("sarthak");
		user.setGender("male");
		
		UserDao dao = new UserDao();
		dao.saveUser(user);
	}

}

