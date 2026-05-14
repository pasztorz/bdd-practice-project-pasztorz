package bddpractice;

import bddpractice.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepDefinitions {
  private User registeredUser;
  private List<User> userList;
  private String loginResult;

  @Given("Bob is a registered user")
  public void bob_is_a_registered_user() {
    /// BOB COULD BE PUT INTO A .env FILE ... (???)
    registeredUser = new User("Bob", "bob@test.com", "TestBob123");
  }

  @When("Bob logs in with {string} and {string}")
  public void bob_logs_in_with(String loginEmail, String loginPassword) {
    LoginService loginService = new LoginService();
    loginResult = loginService.login(registeredUser, loginEmail, loginPassword);
  }

  @Then("Bob sees the following {string}")
  public void bob_sees_the_following(String expectedMessage) {
    assertThat(loginResult).isEqualTo(expectedMessage);
  }

  @Given("Rob is an unregistered user")
  public void rob_is_an_unregistered_user() {
    registeredUser = new User("Bob", "bob@test.com", "TestBob123");
    userList = List.of(registeredUser);
  }

  @When("Rob logs in with new credentials")
  public void Rob_logs_in_with_new_credentials() {
    User newUser = new User("Rob", "rob@test.com", "TestRob123");
    RegisterService registerService = new RegisterService();
    loginResult = registerService.checkRegistration(userList, newUser);
  }

  @Then("Rob sees the following message {string}")
  public void rob_sees_the_following_message(String expectedMessage) {
    assertThat(loginResult).isEqualTo(expectedMessage);
  }
}
