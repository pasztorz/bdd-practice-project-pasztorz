package bddpractice;

import bddpractice.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepDefinitions {
  private User registeredUser;
  private String loginResult;
  private String invalidResult;

  @Given("Bob is a registered user")
  public void bob_is_a_registered_user() {
    registeredUser = new User("Bob", "bob@test.com", "TestBob123");
  }

  @When("Bob logs in with valid credentials")
  public void bob_logs_in_with_valid_credentials() {
    LoginService loginService = new LoginService();
    loginResult = loginService.login(registeredUser, registeredUser.email(), registeredUser.password());
  }

  @Then("Bob sees the success message {string}")
  public void bob_sees_the_success_message(String expectedMessage) {
    assertThat(loginResult).isEqualTo(expectedMessage);
  }

  @Given("Bob is a registered user but")
  public void bob_is_a_registered_user_but() {
    registeredUser = new User("Bob", "bob@test.com", "TestBob123");
  }

  @When("Bob logs in with invalid credentials")
  public void bob_logs_in_with_invalid_credentials() {
    User loginUser = new User("Bob", "bob@test.com", "TestBob1223");
    LoginService loginService = new LoginService();
    invalidResult = loginService.login(registeredUser, loginUser.email(), loginUser.password());
  }

  @Then("Bob sees the failure message {string}")
  public void bob_sees_the_failure_message(String expectedMessage) {
    assertThat(invalidResult).isEqualTo(expectedMessage);
  }
}
