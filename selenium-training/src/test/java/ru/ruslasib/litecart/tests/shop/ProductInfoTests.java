package test.java.ru.ruslasib.litecart.tests.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.testng.Assert.assertTrue;

public class ProductInfoTests extends TestBase {

  @BeforeClass
  public void launch() {
    shop.launch();
  }

  @BeforeMethod
  public void precondition() {
    shop.homePage().goToHomePage();
  }

  @Test
  public void testProductName() {
    List<WebElement> products = shop.homePage().campaignsItems();
    String nameOnMainPage = products.get(0).findElement(By.cssSelector(".name")).getAttribute("textContent");
    products.get(0).click();
    String nameOnProductPage = shop.productPage().productName();
    assertThat(nameOnMainPage, equalTo(nameOnProductPage));
  }

  @Test
  public void testProductPrice() {
    List<WebElement> products = shop.homePage().campaignsItems();
    String regularPriceOnMainPage = products.get(0).findElement(By.cssSelector("s")).getAttribute("textContent");
    String promoPriceOnMainPage = products.get(0).findElement(By.cssSelector("strong")).getAttribute("textContent");
    int regularPriceSizeOnMainPage = fontSize(products.get(0).findElement(By.cssSelector("s")).getCssValue("font-size"));
    int promoPriceSizeOnMainPage = fontSize(products.get(0).findElement(By.cssSelector("strong")).getCssValue("font-size"));
    products.get(0).click();
    String regularPriceOnProductPage = shop.productPage().regularPrice().getAttribute("textContent");
    String promoPriceOnProductPage = shop.productPage().promoPrice().getAttribute("textContent");
    int regularPriceSizeOnProductPage = fontSize(shop.productPage().regularPrice().getCssValue("font-size"));
    int promoPriceSizeOnProductPage = fontSize(shop.productPage().promoPrice().getCssValue("font-size"));
    assertThat(regularPriceOnMainPage, equalTo(regularPriceOnProductPage));
    assertThat(promoPriceOnMainPage, equalTo(promoPriceOnProductPage));
    System.out.println("Промо цена на главной странице: " + promoPriceSizeOnMainPage);
    System.out.println("Обычная цена на главной странице: " + regularPriceSizeOnMainPage);
    assertThat(promoPriceSizeOnProductPage, greaterThan(regularPriceSizeOnProductPage));
    assertThat(promoPriceSizeOnMainPage, greaterThan(regularPriceSizeOnMainPage));
  }

  @Test
  public void testRegularPriceVisualization() {
    List<WebElement> products = shop.homePage().campaignsItems();
    String colorOnMainPage = products.get(0).findElement(By.cssSelector("s")).getCssValue("color");
    products.get(0).click();
    String colorOnProductPage = shop.productPage().regularPrice().getCssValue("color");
    assertTrue(colorIsGrey(colorOnMainPage), "Color is not grey");
    assertTrue(colorIsGrey(colorOnProductPage), "Color is not grey");
  }

  @Test
  public void testPromoPriceVisualization() {
    List<WebElement> products = shop.homePage().campaignsItems();
    String colorOnMainPage = products.get(0).findElement(By.cssSelector("strong")).getCssValue("color");
    products.get(0).click();
    String colorOnProductPage = shop.productPage().promoPrice().getCssValue("color");
    assertTrue(colorIsRed(colorOnMainPage), "Color is not red");
    assertTrue(colorIsRed(colorOnProductPage), "Color is not red");
  }
}
