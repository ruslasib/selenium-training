package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;

public class ProductPage extends Page {

  private WebDriver driver;
  private WebDriverWait wait;

  public ProductPage(WebDriver driver, WebDriverWait wait) {
    super(driver);
    this.driver = driver;
    this.wait = wait;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name^=options]")
  private WebElement sizeField;

  @FindBy(name = "add_cart_product")
  private WebElement addToCart;

  @FindBy(name = "remove_cart_item")
  private WebElement removeBtn;

  @FindBy(css = "#box-checkout-summary td.item")
  private List<WebElement> allOrderedItems;

  @FindBy(css = ".shortcuts > li")
  private List<WebElement> allShortcuts;

  @FindBy(css = "#checkout-cart-wrapper em")
  private WebElement noItemsInYourCart;

  public String productName() {
    return driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");
  }

  public WebElement regularPrice() {
    return driver.findElement(By.cssSelector("#box-product .price-wrapper s"));
  }

  public WebElement promoPrice() {
    return driver.findElement(By.cssSelector("#box-product .price-wrapper strong"));
  }

  public void addToCartButton() {
    click(addToCart);
  }

  public void selectSize() {
    if (isElementPresent(By.cssSelector("[name^=options]"))) {
      new Select(sizeField).selectByIndex(1);
    }
  }

  public void removeButton() {
    click(removeBtn);
  }

  public List<WebElement> allOrderedItems() {
    return allOrderedItems;
  }

  public List<WebElement> allShortcuts() {
    return allShortcuts;
  }

  public void removeAllProductsFromCart() {
    List<WebElement> items = allOrderedItems();
    while (! items.isEmpty()) {
      if (isElementPresent(allShortcuts())) {
        allShortcuts().get(0).click();
      }
      removeButton();
      wait.until(numberOfElementsToBeLessThan(By.cssSelector("#box-checkout-summary td.item"), items.size()));
      items = allOrderedItems();
    }
  }

  public String noItemsInYourCartText() {
    return noItemsInYourCart.getAttribute("textContent");
  }
}
