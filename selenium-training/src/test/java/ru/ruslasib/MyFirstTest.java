package test.java.ru.ruslasib;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {

  private WebDriver driver;

  @Before
  public void start() {
    driver = new ChromeDriver();
  }

  @Test
  public void myFirstTest() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
