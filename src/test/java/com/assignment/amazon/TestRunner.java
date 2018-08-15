package com.assignment.amazon;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.TestCase;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "Feature",
	glue = {"stepDefinitions"},
	plugin = {"pretty", "html:target/cucumber-reports"}
	)
public class TestRunner extends TestCase{
}
