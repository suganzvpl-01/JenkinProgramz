package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/tour.feature",
glue={"com.stepdefinition"},
dryRun=false,
plugin={"pretty","html:target/cucumber-report-html",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"},
monochrome = true,
tags="@Test")

public class TestRunner {

}
