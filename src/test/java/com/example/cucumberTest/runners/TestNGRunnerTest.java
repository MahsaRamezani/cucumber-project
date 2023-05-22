package com.example.cucumberTest.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

/*
 @author m_ramezani
 */

@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml"},
    glue = {"com.example.cucumberTest.stepDefinitions"},
    features = "classpath:features"
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
