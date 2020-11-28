package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class HomePage extends Page {

  WebDriver driver;

  public HomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public List<WebElement> mostPopularItems() {
    return driver.findElements(By.cssSelector("#box-most-popular li"));
  }

  public List<WebElement> campaignsItems() {
    return driver.findElements(By.cssSelector("#box-campaigns li"));
  }

  public List<WebElement> latestProductsItems() {
    return driver.findElements(By.cssSelector("#box-latest-products li"));
  }

  public void goToHomePage() {
    driver.findElement(By.cssSelector("#logotype-wrapper a")).click();
  }

  public void createAccount() {
    click(By.xpath("//*[@inputName='login_form']//a[contains(@href,'create_account')]"));
  }

  public void logout() {
    click(By.cssSelector("#box-account [href$=logout]"));
  }

  public void inputEmail(String email) {
    type(By.cssSelector("[inputName=email]"), email);
  }

  public void inputPassword(String password) {
    type(By.cssSelector("[inputName=password]"), password);
  }

  public void loginButton() {
    click(By.cssSelector("[inputName=login]"));
  }
}
