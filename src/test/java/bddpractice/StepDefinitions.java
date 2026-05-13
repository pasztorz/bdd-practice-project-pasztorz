package bddpractice;

import bddpractice.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepDefinitions {
  private User registeredUser;
  private String loginResult;

  @Given("Bob is a registered user")
  public void bob_is_a_registered_user() {
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
}
