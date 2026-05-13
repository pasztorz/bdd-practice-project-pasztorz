package bddpractice;

import bddpractice.model.User;

public class LoginService {

  public String login(User registeredUser, String loginEmail, String loginPassword) {
    return loginEmail.equals(registeredUser.email())
            && loginPassword.equals(registeredUser.password())
            ? "Welcome back, " + registeredUser.userName() : "Login failed";
  }
}
