package com.endava.btn.gui.automation;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-report/cucumber.json",
        detailedReport = true,
        overviewReport = true,
        toPDF = true,
        outputFolder = "target/cucumber-report"
)
@CucumberOptions(features = {"./src/test/java/resources/features"},
        tags = {"~@ignored"},
        plugin = {"html:target/cucumber-report", "json:target/cucumber-report/cucumber.json",
                "usage:target/cucumber-report/cucumber-usage.json", "junit:target/cucumber-report/cucumber-results.xml",
                "rerun:target/cucumber-report/rerun.txt"},
        monochrome = true)
public class RunGUITests {
}
