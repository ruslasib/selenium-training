package test.java.ru.ruslasib;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class StartBrowsersExamples {

  private WebDriver driver;

  @Test
  public void startChrome() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    doSomething();
  }

  @Test
  public void startFirefox() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments();driver = new FirefoxDriver(options);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    doSomething();
  }

  @Test
  public void startEdge() {
    // код, который находит драйвер Edge
    // driver = new EdgeDriver(new EdgeDriverService.Builder()
    //        .usingDriverExecutable(new File("C:\\Tools\\msedgedriver.exe")).build());

    // код, который не находит драйвер Edge
    driver = new EdgeDriver();
    doSomething();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  public void doSomething() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }
}
