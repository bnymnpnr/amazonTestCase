package com.amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // create a report
        plugin = {"json:target/cucumber.json"},
        // where our feature files are located:
        features = "src/test/resources/",
        glue = "com/amazon/stepdefinitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {

}
