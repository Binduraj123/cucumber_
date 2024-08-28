package Hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    WebDriver driver;
    Properties p;

    @Before
    public void setup() throws IOException {
        // Initialize the WebDriver
        driver = BaseClass.initilizeBrowser();
        if (driver == null) {
            throw new RuntimeException("Failed to initialize WebDriver");
        }
        // Load properties
        p = BaseClass.getProperties();
        // Navigate to the application URL
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
        // Set WebDriver instance in BaseClass
       
    }

    @After
    public void teardown(Scenario scenario) {
        // Quit the WebDriver if it is not null
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        // Take screenshot if the scenario fails
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}