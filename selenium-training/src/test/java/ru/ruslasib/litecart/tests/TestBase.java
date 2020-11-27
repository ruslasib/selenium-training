package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

  public WebDriver driver;
  protected WebDriverWait wait;
  protected LitecartAdmin litecartAdmin;
  protected Shop shop;

  @BeforeClass
  public void start() {
    // uncomment to launch Chrome
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("start-maximized");
//    driver = new ChromeDriver(options);
    // uncomment to launch Edge
//    driver = new EdgeDriver(new EdgeDriverService.Builder()
//            .usingDriverExecutable(new File("C:\\Tools\\msedgedriver.exe")).build());
    //uncomment to launch Firefox
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
    driver = new FirefoxDriver(options);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
    } catch (InvalidSelectorException ex) {
      throw ex;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void login(String login, String password) {
    typeLogin(login);
    typePassword(password);
    clickLogin();
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void typeLogin(String login) {
    type(By.name("username"), login);
  }

  private void type(By locator, String userInput) {
    driver.findElement(locator).sendKeys(userInput);
  }

  public void typePassword(String password) {
    type(By.name("password"), password);
  }

  public void clickLogin() {
    click(By.cssSelector("button[name=login]"));
  }

  protected boolean colorIsGrey(String color) {
    String [] newColor = color.split(",");
    List<String> result = new ArrayList<>();
    for (String c : newColor) {
      result.add(c.replaceAll("[^0-9]", ""));
    }
    if (result.get(0).equals(result.get(1))
            && result.get(1).equals(result.get(2))) {
      return true;
    } else {
      return false;
    }
  }

  protected boolean colorIsRed(String color) {
    String [] newColor = color.split(",");
    List<String> result = new ArrayList<>();
    for (String c : newColor) {
      result.add(c.replaceAll("[^0-9]", ""));
    }
    if (result.get(1).equals("0")
            && result.get(2).equals("0")) {
      return true;
    } else {
      return false;
    }
  }

  protected int fontSize(String sizeInfo) {
    return Integer.parseInt(sizeInfo.replaceAll("[^0-9]", ""));
  }
}
