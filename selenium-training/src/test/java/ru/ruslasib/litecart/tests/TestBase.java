package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {

  private WebDriver driver;
  protected WebDriverWait wait;
  protected LitecartAdmin litecartAdmin;
  protected Shop shop;

  @BeforeClass
  public void start() {
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("start-maximized");
//    driver = new ChromeDriver(options);
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
    driver = new FirefoxDriver(options);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 10);
    litecartAdmin = new LitecartAdmin(driver);
    shop = new Shop(driver);
  }

  @AfterClass
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
