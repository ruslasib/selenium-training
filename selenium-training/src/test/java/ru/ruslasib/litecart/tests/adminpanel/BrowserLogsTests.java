package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

public class BrowserLogsTests extends TestBase {

  @BeforeClass
  public void prepare() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testBrowserLogs() {
    String url = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
    By locator = By.cssSelector("tr.row > td:nth-of-type(3) > [href*='product_id']");
    driver.get(url);
    List<WebElement> products = driver.findElements(locator);
    int count = 1;
    boolean isThereErrors = false;
    List<LogEntry> errorsList = new ArrayList<>();
    while (! products.isEmpty()) {
      products.get(0).click();
      List<LogEntry> log = driver.manage().logs().get("browser").getAll();
      if (log.size() > 0) {
        isThereErrors = true;
        log.stream().forEach(l -> System.out.println(l));
        log.stream().forEach(l -> errorsList.add(l));
      }
      driver.get(url);
      products = driver.findElements(locator);
      products = products.subList(count, products.size());
      count = count + 1;
    }
    System.out.println("Is there errors: " + isThereErrors);
    System.out.println("Errors found during test:");
    errorsList.stream().forEach(e -> System.out.println(e));
    assertFalse(isThereErrors);
  }
}