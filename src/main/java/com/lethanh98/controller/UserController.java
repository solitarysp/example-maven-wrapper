package com.lethanh98.controller;

import com.lethanh98.entity.User;
import com.lethanh98.repo.UserRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

  @Autowired
  UserRepo userRepo;

  @GetMapping()
  public List<User> get() {
    List<User> users = (List<User>) userRepo.findAll();
    return users;
  }

  @PostMapping()
  @Transactional
  public User post(String firstName, String lastName) {
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    return userRepo.save(user);
  }
}
