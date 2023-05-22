package com.example.cucumberTest.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author m_ramezani
 */
public class AuthenticationStepDefinitions {

  @Before
  public void setup() {
    System.out.println("============================================================");
    System.out.println("Before hook");
    System.out.println("------------------------------------------------------------");
  }

  @BeforeStep("@ui")
  public void stepSetup() {
    System.out.println("************************************************************");
    System.out.println("Before Step");
  }

  @After
  public void teardown() {
    System.out.println("============================================================");
    System.out.println("After hook");
    System.out.println("------------------------------------------------------------");
  }

  @AfterStep("@ui")
  public void stepTeardown() {
    System.out.println("After Step");
    System.out.println("************************************************************");
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

  @When("the user clicks on Forgot Username")
  public void the_user_clicks_on_forgot_username() {
    System.out.println("here we are with Baam logo B<>A<>A<>M");
  }
  @Then("the user should be navigated to the first page of forgot username flow")
  public void the_user_should_be_navigated_to_the_first_page_of_forgot_username_flow() {
    System.out.println("here we are with Baam logo B<>A<>A<>M");
  }
}
