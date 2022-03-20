package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.User;


public interface IUserService { 
	 
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);

} 
 