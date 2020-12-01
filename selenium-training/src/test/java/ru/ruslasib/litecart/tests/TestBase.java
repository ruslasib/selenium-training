package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.java.ru.ruslasib.litecart.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    // uncomment to launch Firefox Nightly
//    DesiredCapabilities caps = new DesiredCapabilities();
//    caps.setCapability("unexpectedAlertBehaviour", "accept");
//    caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, caps);
//    FirefoxOptions options = new FirefoxOptions();
//    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
//    driver = new FirefoxDriver(caps);

    // uncomment to launch Firefox
    driver = new FirefoxDriver();

    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 5);
    litecartAdmin = new LitecartAdmin(driver);
    shop = new Shop(driver);
  }

  @AfterClass
  public void stop() {
    driver.quit();
    driver = null;
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
    click(By.cssSelector("button[inputName=login]"));
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

  protected boolean isElementPresent(By locator) {
    try {
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      return driver.findElements(locator).size() > 0;
    } catch (InvalidSelectorException ex) {
      throw ex;
    } catch (NoSuchElementException ex) {
      throw ex;
    }
    finally {
      driver.manage().timeouts().implicitlyWait(ParametersHolder.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
  }

  protected boolean isElementNotPresent(By locator) {
    try {
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      return driver.findElements(locator).size() == 0;
    } finally {
      driver.manage().timeouts().implicitlyWait(ParametersHolder.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
  }

  public String getNewWindow (Set<String> oldWindows, WebDriver driver) {
    wait.until(ExpectedConditions.anyWindowOtherThan(oldWindows));
    Set<String> newWindows = driver.getWindowHandles();
    newWindows.removeAll(oldWindows);
    return newWindows.iterator().next();
  }
}
