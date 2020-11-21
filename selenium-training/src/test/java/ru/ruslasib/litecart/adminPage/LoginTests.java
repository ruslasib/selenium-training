package test.java.ru.ruslasib.litecart.adminPage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.TestBase;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class LoginTests extends TestBase {

  @Test
  public void testLogin() {
    String login = "admin";
    String password = "admin";
    driver.get("http://localhost/litecart/admin/login.php/");
    driver.findElement(By.name("username")).sendKeys(login);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.cssSelector("button[name=login]")).click();
    WebElement mainPageTitle = wait.until(presenceOfElementLocated(By.id("platform")));
    assertThat(mainPageTitle.getText(), containsString("LiteCart"));
  }
}
