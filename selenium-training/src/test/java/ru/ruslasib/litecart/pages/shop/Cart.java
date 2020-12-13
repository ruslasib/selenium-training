package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.ru.ruslasib.litecart.pages.Page;

public class Cart extends Page {

  private WebDriver driver;

  public Cart(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "#cart-wrapper .quantity")
  private WebElement quantity;

  @FindBy(css = ".link[href$=checkout]")
  private WebElement checkoutBtn;

  public void checkoutButton() {
    click(checkoutBtn);
  }

  public int quantityValue() {
    return Integer.parseInt(quantity.getAttribute("textContent"));
  }

  public WebElement quantity() {
    return quantity;
  }

}
