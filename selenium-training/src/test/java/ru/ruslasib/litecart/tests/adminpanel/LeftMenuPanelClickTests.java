package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeftMenuPanelClickTests extends TestBase {

  @BeforeClass
  public void launch() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testLeftMenu() {
    List<WebElement> currentItems = driver.findElements(By.cssSelector("#app- > a"));
    int count = 1;
    while (! currentItems.isEmpty()) {
      WebElement currentElement = currentItems.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));

      List<WebElement> currentSubmenuItems = driver.findElements(By.cssSelector("#app- > ul a"));
      int countSub = 1;
      while (! currentSubmenuItems.isEmpty()) {
        WebElement currentSubmenuElement = currentSubmenuItems.get(0);
        currentSubmenuElement.click();
        isElementPresent(By.tagName("h1"));
        currentSubmenuItems = driver.findElements(By.cssSelector("#app- > ul a"));
        currentSubmenuItems = currentSubmenuItems.subList(countSub, currentSubmenuItems.size());
        countSub = countSub + 1;
      }

      currentItems = driver.findElements(By.cssSelector("#app- > a"));
      currentItems = currentItems.subList(count, currentItems.size());
      count = count + 1;
    }
  }
}
