package test.java.ru.ruslasib.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTests {

  private WebDriver driver;

  @Before
  public void start() {
    driver = new ChromeDriver();
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
