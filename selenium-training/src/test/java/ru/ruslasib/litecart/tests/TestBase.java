package test.java.ru.ruslasib.litecart.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {

  private WebDriver driver;
  protected WebDriverWait wait;
  protected Litecart litecart;

  @Before
  public void start() {
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("start-maximized");
//    driver = new ChromeDriver(options);
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
    driver = new FirefoxDriver(options);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
    litecart = new Litecart(driver);
    litecart.launch();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch(InvalidSelectorException ex) {
      throw ex;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
