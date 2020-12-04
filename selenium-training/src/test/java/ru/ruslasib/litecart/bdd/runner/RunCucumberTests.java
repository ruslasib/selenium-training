package test.java.ru.ruslasib.litecart.bdd.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\repository\\selenium-training\\selenium-training\\src\\test\\java\\ru\\ruslasib\\resource\\features",
         plugin = {"pretty", "html:build/cucumber-report"})

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
