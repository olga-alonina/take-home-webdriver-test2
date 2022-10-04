package com.dotdash.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "@target/rerun.txt",
            glue = "com/dotdash/step_definitions"

    )
    public class FailedTestRunner {
    }
