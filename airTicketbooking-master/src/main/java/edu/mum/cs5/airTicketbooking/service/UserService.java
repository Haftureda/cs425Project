package edu.mum.cs5.airTicketbooking.service;


import edu.mum.cs5.airTicketbooking.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public void saveUser(User user);
	
	//public User checkCredentials(User user);
}