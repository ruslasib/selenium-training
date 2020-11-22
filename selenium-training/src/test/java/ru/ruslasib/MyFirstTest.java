package test.java.ru.ruslasib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {

  private WebDriver driver;

  @BeforeMethod
  public void start() {
    driver = new ChromeDriver();
  }

  @Test
  public void myFirstTest() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }

  @AfterMethod
  public void stop() {
    driver.quit();
    driver = null;
  }
}
