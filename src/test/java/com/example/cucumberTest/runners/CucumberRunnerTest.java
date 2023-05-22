package com.example.cucumberTest.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author m_ramezani
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml"},
    glue = {"com.example.cucumberTest.stepDefinitions"},
    tags = "@datadriven",
    features = "classpath:features"
)
public class CucumberRunnerTest {

}
