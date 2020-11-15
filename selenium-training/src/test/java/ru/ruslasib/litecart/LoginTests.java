package test.java.ru.ruslasib.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class LoginTests {

  private WebDriver driver;

  @Before
  public void start() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("unhandledPromptBehavior", "dismiss and notify");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new InternetExplorerDriver(capabilities);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() {
    String login = "admin";
    String password = "admin";
    driver.get("http://localhost/litecart/admin/login.php/");
    driver.findElement(By.name("username")).sendKeys(login);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("login")).click();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
