package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AddNewProduct extends Page {

  private WebDriver driver;
  private WebDriverWait wait;
  private General general;
  private Information information;
  private Prices prices;

  public AddNewProduct(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    this.driver = driver;
    this.wait = wait;
    general = new General(driver);
    information = new Information(driver);
    prices = new Prices(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[href$=tab-information]")
  private WebElement informationTabBtn;

  @FindBy(css = "[href$=tab-prices]")
  private WebElement pricesTabBtn;

  public General general() {
    return general;
  }

  public Information information() {
    return information;
  }

  public Prices prices() {
    return prices;
  }

  public void generalTab() {
    click(By.cssSelector("[href$=tab-general]"));
  }

  public void informationTab() {
    click(informationTabBtn);
    wait.until(presenceOfElementLocated(By.name("manufacturer_id")));
  }

  public void pricesTab() {
    click(pricesTabBtn);
    wait.until(presenceOfElementLocated(By.id("tab-prices")));
  }
}
