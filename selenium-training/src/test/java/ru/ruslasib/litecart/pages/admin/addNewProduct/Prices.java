package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class Prices extends Page {

  private WebDriver driver;

  public Prices(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void inputPurchasePrice(String purchasePrice) {
    clear(By.name("purchase_price"));
    type(By.name("purchase_price"), purchasePrice);
  }

  public void selectCurrency(String currency) {
    click(By.name("purchase_price_currency_code"));
    chooseElementFromDropbox(By.cssSelector("[name=purchase_price_currency_code] option"), currency, "value");
  }

  public void inputPriceUSD(String priceUSD) {
    type(By.cssSelector("[type=text][name*=USD]"), priceUSD);
  }

  public void inputPriceUSDIncludinTax(String priceUSDIncludingTax) {
    clear(By.cssSelector("[type=number][name*=USD]"));
    type(By.cssSelector("[type=number][name*=USD]"), priceUSDIncludingTax);
  }

  public void inputPriceEUR(String priceEUR) {
    type(By.cssSelector("[type=text][name*=EUR]"), priceEUR);
  }


  public void inputPriceEURIncludingTax(String priceEURIncludingTax) {
    clear(By.cssSelector("[type=number][name*=EUR]"));
    type(By.cssSelector("[type=number][name*=EUR]"), priceEURIncludingTax);
  }

  public void save() {
    click(By.name("save"));
  }
}
