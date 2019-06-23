package edu.mum.cs5.airTicketbooking.serviceImpl;

import edu.mum.cs5.airTicketbooking.model.Role;
import edu.mum.cs5.airTicketbooking.model.User;
import edu.mum.cs5.airTicketbooking.repository.RoleRepository;
import edu.mum.cs5.airTicketbooking.repository.UserRepository;
import edu.mum.cs5.airTicketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

//@Order(1)
@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 @Autowired
 private RoleRepository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public User findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }

 @Override 
 public void saveUser(User user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  Role userRole = roleRespository.findByRole("ADMIN");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }





}