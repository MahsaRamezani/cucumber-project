package com.example.cucumberTest.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author m_ramezani
 */
public class LoginDataStepDefinitions {
  @When("the user enters user id as {string}")
  public void the_user_enters_account_name_as(String username) {
    System.out.println("The username is :: " + username);
  }
  @When("enters password as {string}")
  public void enters_password_as(String password) {
    System.out.println("The password is (don't look at me) :: " + password);
  }
}
