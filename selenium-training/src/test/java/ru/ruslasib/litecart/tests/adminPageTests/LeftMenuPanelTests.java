package test.java.ru.ruslasib.litecart.tests.adminPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LeftMenuPanelTests extends TestBase {

  @BeforeClass
  public void login() {
    litecart.loginPage().login("admin", "admin");
  }

  @Test
  public void testAppearance() {
    litecart.leftMenu().click(By.cssSelector("[href$=template]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Template"));
  }

  @Test
  public void testTemplate() {
    litecart.leftMenu().click(By.cssSelector("[href*=template]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Template"));
  }

  @Test
  public void testCatalog() {
    litecart.leftMenu().click(By.cssSelector("[href*=catalog]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Catalog"));
  }
}
