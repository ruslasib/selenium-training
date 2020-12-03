package test.java.ru.ruslasib.litecart.bdd.runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"pretty", "html:build/cucumber-report"},
        tags = "@sanity")

public class RunCucumberTests {

}
