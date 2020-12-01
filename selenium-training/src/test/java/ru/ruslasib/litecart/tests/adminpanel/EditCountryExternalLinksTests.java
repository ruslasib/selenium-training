package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.*;

public class EditCountryExternalLinksTests extends TestBase {

  @BeforeClass
  public void launch() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testExternalLinks() {
    litecartAdmin.leftMenu().countries();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.countries().editCountry("Macedonia");
    List<WebElement> links = driver.findElements(By.cssSelector(".fa-external-link"));
    String mainWindow = driver.getWindowHandle();
    Set<String> oldWindows = driver.getWindowHandles();
    for (WebElement link : links) {
      link.click();
      String newWindow = getNewWindow(oldWindows, driver);
      driver.switchTo().window(newWindow);
      assertNotEquals(mainWindow, newWindow);
      driver.close();
      driver.switchTo().window(mainWindow);
      assertThat(mainWindow, equalTo(driver.getWindowHandle()));
    }
  }
}
