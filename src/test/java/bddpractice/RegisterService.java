package bddpractice;

import bddpractice.model.User;

import java.util.List;

public class RegisterService {

  public String checkRegistration(List<User> userList, User newUser) {
    return userList.contains(newUser) ? "OK" : "Unregistered user";
  }
}
