package com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/step_definations",
        plugin = {"html:target/default-failed-cucumber-reports"}
               //"json:target/cucumber.json"}//we need take it out json cucumber report hear,bc when you run
        // CucumberRunner.class via terminal as (mvn verify -Dcucumber.options="--tags @account_summary") it does not genarate
        // maven-cucumber -report, bc overriding with FailedRunner.class's maven-cucumber-report.
        //if something fail, it not generating default-failed-cucumber-reports result
//faqat endi failed-cucumber-report yuq with mvn command bn.
)
public class FailedReRun {


}
