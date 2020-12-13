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

  public void inputPurchasePrice(int purchasePrice) {
    clear(By.name("purchase_price"));
    type(By.name("purchase_price"), Integer.toString(purchasePrice));
  }

  public void selectCurrency(String currency) {
    click(By.name("purchase_price_currency_code"));
    chooseElementFromDropbox(By.cssSelector("[name=purchase_price_currency_code] option"), currency, "value");
  }

  public void inputPriceUSD(int priceUSD) {
    type(By.cssSelector("[type=text][name*=USD]"), Integer.toString(priceUSD));
  }

  public void inputPriceUSDIncludinTax(String priceUSDIncludingTax) {
    clear(By.cssSelector("[type=number][name*=USD]"));
    type(By.cssSelector("[type=number][name*=USD]"), priceUSDIncludingTax);
  }

  public void inputPriceEUR(int priceEUR) {
    type(By.cssSelector("[type=text][name*=EUR]"), Integer.toString(priceEUR));
  }


  public void inputPriceEURIncludingTax(String priceEURIncludingTax) {
    clear(By.cssSelector("[type=number][name*=EUR]"));
    type(By.cssSelector("[type=number][name*=EUR]"), priceEURIncludingTax);
  }
}
