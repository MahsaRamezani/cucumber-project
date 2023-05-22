package com.example.cucumberTest.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * @author m_ramezani
 */
public class AuthenticationStepDefinitions {

  @LocalServerPort
  private int port;

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
  @Then("the user should be logged in successfull")
  public void the_user_should_be_logged_in_successfull() {
    System.out.println("the user logged in");
  }

}
