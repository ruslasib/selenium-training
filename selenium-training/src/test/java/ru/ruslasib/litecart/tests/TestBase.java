package test.java.ru.ruslasib.litecart.tests;

import com.google.common.io.Files;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.java.ru.ruslasib.litecart.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

  public EventFiringWebDriver driver;
  public BrowserMobProxy proxy;
  protected WebDriverWait wait;
  protected LitecartAdmin litecartAdmin;
  protected Shop shop;
  public DataProviders dataProviders;

  @BeforeClass
  public void start() {
    // proxy
    proxy = new BrowserMobProxyServer();
    proxy.start(0);
    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

    // TODO: make traffic run through fiddler
    Proxy proxy = new Proxy();
    proxy.setHttpProxy("localhost:8866");
    //

    // uncomment to launch Chrome
//    ChromeOptions options = new ChromeOptions();
//    options.setAcceptInsecureCerts(true);
//    options.merge(capabilities);
    // приводим драйвер к классу, который отлавливает события
//    driver = new EventFiringWebDriver(new ChromeDriver(options));
    // регистрируем нового слушателя событий

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

//     uncomment to launch Firefox
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments();
    options.merge(capabilities);
    driver = new EventFiringWebDriver(new FirefoxDriver(options));

    // common for all browsers
    driver.register(new EventListener());
    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 5);
    litecartAdmin = new LitecartAdmin(driver);
    shop = new Shop(driver);
    dataProviders = new DataProviders();
  }

//  @BeforeClass
//  public void startGrid() throws MalformedURLException {
//    DesiredCapabilities caps = new DesiredCapabilities();
//    driver = new RemoteWebDriver(new URL("http://192.168.0.15:4444/wd/hub/"), new ChromeOptions());
//  }

  @AfterClass
  public void stop() {
    driver.quit();
    driver = null;
  }

  // слушатель для логирования событий
  class EventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("Locator " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("Locator " + by + " is found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
      System.out.println("Element " + element + " is prepared to be clicked");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
      System.out.println("Element " + element + " is clicked");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
      // снимаем скриншот события
      File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screenShot = new File("screenshot_" + System.currentTimeMillis() + ".png");
      try {
        Files.copy(tmp, screenShot);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Screenshot name: " + screenShot.getName());
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

  public String getNewWindowId(Set<String> oldWindows, WebDriver driver) {
    Set<String> newWindows = driver.getWindowHandles();
    newWindows.removeAll(oldWindows);
    return newWindows.iterator().next();
  }
}
