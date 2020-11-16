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
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class StartBrowsersExamples {

  private WebDriver driver;

  // Предпочтительно путь до драйвера прописывать в переменных окружения PATH
  @Test
  public void launchChrome() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("strictFileInteractability", true);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

    // использовать этот конструктор нежелательно, так как он deprecated
    // driver = new ChromeDriver(capabilities);

    // лучше использовать конструктор с ChromeOptions
    driver = new ChromeDriver(options);
    doSomething();
  }

  // Путь до драйвера можно положить куда угодно на диск, указав путь до него явно в коде
  @Test
  public void launchChromeWhenDriverSomewhereInOS() {
    System.setProperty("webdriver.chrome.driver", "d:\\Software_testing\\Distrib\\chromedriver.exe");
    driver = new ChromeDriver();
    doSomething();
  }

  @Test
  public void launchFirefox() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments();driver = new FirefoxDriver(options);
    doSomething();
  }

  @Test
  public void launchEdge() {
    // у меня браузер Edge запустился только, когда явно указан путь до веб драйвера
    driver = new EdgeDriver(new EdgeDriverService.Builder()
            .usingDriverExecutable(new File("C:\\Tools\\msedgedriver.exe")).build());
    // а вот этот код для Edge не сработал. Путь до драйвера был прописан в PATH
    // для Chrome и Firefox похожий код сработал без явного указания пути до драйвера
    // driver = new EdgeDriver();
    doSomething();
  }

  // TODO неверный конструктор для инициализации драйвера
  @Test
  public void launchFireFoxNightly() {
    DesiredCapabilities caps = new DesiredCapabilities();
    // MARIONETTE можно явно не указывать, тогда он по умолчанию станет true
    caps.setCapability(FirefoxDriver.MARIONETTE, true);
    driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")),
            new FirefoxProfile(), caps);
  }

  // запуск Firefox (на примере v45 ESR) "по старой схеме"
  @Test
  public void launchFirefox45ESR() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, false);
    driver = new FirefoxDriver(caps);
    doSomething();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  public void doSomething() {
    System.out.println(((HasCapabilities) driver).getCapabilities());
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }
}
