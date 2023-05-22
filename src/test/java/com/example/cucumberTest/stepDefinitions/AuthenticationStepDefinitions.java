package com.example.cucumberTest.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * @author m_ramezani
 */
public class AuthenticationStepDefinitions {

  @Before
  public void setup(Scenario scenario) {
    System.out.println("============================================================");
    System.out.println("scenario name :: " + scenario.getName());
    System.out.println("scenario tags :: " + scenario.getSourceTagNames());
    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
  }

  @After
  public void teardown() {
    System.out.println("============================================================");
  }

  @Given("the user is on the login page")
  public void the_user_is_on_the_login_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("The user is on login page");
    
  }
  @When("the user enters valid credentials")
  public void the_user_enters_valid_credentials() {
    System.out.println("Entered username and password");
  }
  @When("hits submit")
  public void hits_submit() {
    System.out.println("Clicked on submit");
  }
  @Then("the user should be logged in successfully")
  public void the_user_should_be_logged_in_successfully() {
    System.out.println("the user logged in");
  }

  @When("the user enters invalid credentials")
  public void the_user_enters_invalid_credentials() {
    System.out.println("Entered invalid credentials");
  }
  @Then("an invalid credentials error message should be displayed to the user")
  public void an_invalid_credentials_error_message_should_be_displayed_to_the_user() {
    System.out.println("error displayed:::Username or password invalid");
  }
  @Then("login should be unsuccessful")
  public void login_should_be_unsuccessful() {
    System.out.println("the user cannot logged in");
  }

  @Then("the Baam Logo should be present in the login form")
  public void the_baam_logo_should_be_present_in_the_login_form() {
    System.out.println("here we are with Baam logo B<>A<>A<>M");
  }

  @When("the user enters user id as {string}")
  public void the_user_enters_account_name_as(String username) {
    System.out.println("The username is :: " + username);
  }
  @When("enters password as {string}")
  public void enters_password_as(String password) {
    System.out.println("The password is (don't look at me) :: " + password);
  }
}
