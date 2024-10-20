package com.nesreading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nesreading.domain.User;
import com.nesreading.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User handleCreateUser(User user) {
    return this.userRepository.save(user);
  }

  public List<User> handleFetchAllUser() {
    return this.userRepository.findAll();
  }

  public Optional<User> handleFetchUserById(long id) {
    return this.userRepository.findById(id);
  }

  public User handleUpdateUser(User user) {
    User dbUser = userRepository.findById(user.getId()).get();

    dbUser.setFullName(user.getFullName());
    dbUser.setAddress(user.getAddress());

    return this.userRepository.save(dbUser);
  }

  public void handleDeleteUser(long id) {
    userRepository.deleteById(id);
  }

}
