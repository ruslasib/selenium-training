package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;

public class LeftMenuPanelClickTests extends TestBase {

  @BeforeClass
  public void launch() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testLeftMenu() {
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuAppearanceSubItems() {
    click(By.cssSelector("[href$=template]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuCatalogSubItems() {
    click(By.cssSelector("[href$=catalog]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuCustomersSubItems() {
    click(By.cssSelector("[href$=customers]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuLanguagesSubItems() {
    click(By.cssSelector("[href$=languages]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuModulesSubItems() {
    click(By.cssSelector("[href$=jobs]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuOrdersSubItems() {
    click(By.cssSelector("[href$=orders]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuReportsSubItems() {
    click(By.cssSelector("[href$=monthly_sales]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuSettingsSubItems() {
    click(By.cssSelector("[href$=store_info]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuTaxSubItems() {
    click(By.cssSelector("[href$=tax_classes]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuTranslationsSubItems() {
    click(By.cssSelector("[href$=search]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }

  @Test
  public void testLeftMenuVQmodsSubItems() {
    click(By.cssSelector("[href$=vqmods]"));
    List<WebElement> currentList = driver.findElements(By.cssSelector("#app- > ul a"));
    int count = 1;
    while (! currentList.isEmpty()) {
      WebElement currentElement = currentList.get(0);
      currentElement.click();
      isElementPresent(By.tagName("h1"));
      currentList = driver.findElements(By.cssSelector("#app- > ul a"));
      currentList = currentList.subList(count, currentList.size());
      count = count + 1;
    }
  }
}
