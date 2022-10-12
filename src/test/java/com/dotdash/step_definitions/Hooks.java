package com.dotdash.step_definitions;

import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

        @BeforeClass
        public void setup(String pageName) {
            Driver.get().get(ConfigurationReader.getProperty("baseUrl") + pageName);
            Driver.get().manage().window().maximize();
        }

        @AfterClass
        public void teardown(Scenario scenario) {
            if(scenario.isFailed()){
                System.out.println("Test Failed");
                byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png", "screenFails");
            }else {
                System.out.println("Cleanup!");
                System.out.println("Test Completed");
            }
            Driver.get().quit();
        }
    }