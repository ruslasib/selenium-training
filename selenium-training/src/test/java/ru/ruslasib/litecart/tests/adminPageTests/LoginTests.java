package test.java.ru.ruslasib.litecart.tests.adminPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class LoginTests extends TestBase {

  @Test
  public void testLogin() {
    litecartAdmin.loginPage().typeLogin("admin");
    litecartAdmin.loginPage().typePassword("admin");
    litecartAdmin.loginPage().clickLogin();
    WebElement mainPageTitle = wait.until(presenceOfElementLocated(By.id("platform")));
    assertThat(mainPageTitle.getText(), containsString("LiteCart"));
  }
}
