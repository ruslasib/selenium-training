package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import test.java.ru.ruslasib.litecart.pages.Page;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;

public class CreateAccount extends Page {

  private WebDriver driver;

  public CreateAccount(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void inputFirstName(String firstName) {
    type(By.cssSelector("[name=firstname]"), firstName);
  }

  public void inputLastName(String lastName) {
    type(By.cssSelector("[name=lastname]"), lastName);
  }

  public void inputAddress1(String address1) {
    type(By.cssSelector("[name=address1]"), address1);
  }

  public void inputPostcode(String postcode) {
    type(By.cssSelector("[name=postcode]"), postcode);
  }

  public void inputCity(String city) {
    type(By.cssSelector("[name=city]"), city);
  }

  public void inputEmail(String email) {
    type(By.cssSelector("[name=email]"), email);
  }

  public void inputPhone(String phone) {
    type(By.cssSelector("[name=phone]"), phone);
  }

  public void inputDesiredPassword(String password) {
    type(By.cssSelector("[name=password]"), password);
  }

  public void inputConfirmPassword(String password) {
    type(By.cssSelector("[name=confirmed_password]"), password);
  }

  public void createAccount() {
    click(By.cssSelector("[name=create_account]"));
  }

  public void chooseCountry(String countryName) {
    click(By.cssSelector("[id *= select2-country_code]"));
    type(By.cssSelector(".select2-search__field"), countryName);
    List<WebElement> countries = driver.findElements(By.cssSelector("[id*=select2-country_code]"));
    for (WebElement country : countries) {
      if (country.getAttribute("textContent").equals(countryName)) {
        country.click();
        return;
      }
    }
  }

  public void chooseState(String stateName) {
    click(By.cssSelector("select[name=zone_code]"));
    List<WebElement> countries = driver.findElements(By.cssSelector("[name=zone_code] > option"));
    for (WebElement country : countries) {
      if (country.getAttribute("textContent").equals(stateName)) {
        country.click();
        return;
      }
    }
  }
}
