package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.ru.ruslasib.litecart.pages.Page;

public class Prices extends Page {

  private WebDriver driver;

  public Prices(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(name = "purchase_price")
  private WebElement purchasePriceField;

  @FindBy(name = "purchase_price_currency_code")
  private WebElement purchasePriceCurrency;

  @FindBy(css = "[type=text][name*=USD]")
  private WebElement priceUSDField;

  @FindBy(css = "[type=text][name*=EUR]")
  private WebElement priceEURField;

  public void inputPurchasePrice(int purchasePrice) {
    typeIn(purchasePriceField, Integer.toString(purchasePrice));
  }

  public void selectCurrency(String currency) {
    select(purchasePriceCurrency, currency);
  }

  public void inputPriceUSD(int priceUSD) {
    typeIn(priceUSDField, Integer.toString(priceUSD));
  }

  public void inputPriceEUR(int priceEUR) {
    typeIn(priceEURField, Integer.toString(priceEUR));
  }
}
