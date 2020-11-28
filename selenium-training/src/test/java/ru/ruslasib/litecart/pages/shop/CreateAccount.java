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
    type(By.cssSelector("[inputName=firstname]"), firstName);
  }

  public void inputLastName(String lastName) {
    type(By.cssSelector("[inputName=lastname]"), lastName);
  }

  public void inputAddress1(String address1) {
    type(By.cssSelector("[inputName=address1]"), address1);
  }

  public void inputPostcode(String postcode) {
    type(By.cssSelector("[inputName=postcode]"), postcode);
  }

  public void inputCity(String city) {
    type(By.cssSelector("[inputName=city]"), city);
  }

  public void inputEmail(String email) {
    type(By.cssSelector("[inputName=email]"), email);
  }

  public void inputPhone(String phone) {
    type(By.cssSelector("[inputName=phone]"), phone);
  }

  public void inputDesiredPassword(String password) {
    type(By.cssSelector("[inputName=password]"), password);
  }

  public void inputConfirmPassword(String password) {
    type(By.cssSelector("[inputName=confirmed_password]"), password);
  }

  public void createAccount() {
    click(By.cssSelector("[inputName=create_account]"));
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
    click(By.cssSelector("select[inputName=zone_code]"));
    List<WebElement> countries = driver.findElements(By.cssSelector("[inputName=zone_code] > option"));
    for (WebElement country : countries) {
      if (country.getAttribute("textContent").equals(stateName)) {
        country.click();
        return;
      }
    }
  }
}
