package com.cydeo.runners;



import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",//type="html" of your report after : location of your report/name of your report.html
        "json:target/cucumber.json",
        "junit:target/junit/junit-report.xml"},
        features = "src/test/resources/features", //same directors az project
        glue = "com/cydeo/step_definitions",//under same directory
        dryRun = false,//false mean run the test true means dont run just give me the methode
        tags = "@validLogin",// give tag to library// empty tag="", means run everything
        publish = true //generating a report with public link
)
public class CukesRunner {




}
