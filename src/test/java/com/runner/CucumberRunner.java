package com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/step_definations",
        dryRun = false,
        tags ="@find_transaction",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                 "rerun:target/rerun.txt"}
)
public class CucumberRunner {
}
