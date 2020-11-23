package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features/account.activity",
                     "src/test/resources/features/account.summary",
                     "src/test/resources/features/login",
                     "src/test/resources/features/pay.bills" },
        glue = "com/step_definations",
        dryRun = false,

        plugin = {"html:target/default-regression-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"}
)
//This class dedicated run only regression, we specify/include curtain module/component
public class RegressionRunner {
}
//if you click RegressionRunner class, parallelization not happens, in order to achieve the parallel run, run your test through terminal
//command is: mvn test -P Regression