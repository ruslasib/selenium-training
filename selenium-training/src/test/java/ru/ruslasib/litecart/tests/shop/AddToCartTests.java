package test.java.ru.ruslasib.litecart.tests.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertTrue;

public class AddToCartTests extends TestBase {

  @BeforeClass
  public void launch() {
    shop.launch("https://litecart.stqa.ru/en/");
    shop.homePage().login("ruslan@ruslan.ru", "123456");
  }

  @Test
  public void testAddToAndRemoveFromCart() {
    // добавляем товары в корзину
    for (int i = 0; i <= 2; i++) {
      shop.homePage().goToHomePage();
      shop.homePage().mostPopularItems().get(0).click();
      shop.productPage().selectSize();
      int quantityBefore = Integer.parseInt(shop.productPage().quantity().getAttribute("textContent"));
      int quantityAfter = quantityBefore + 1;
      shop.productPage().addToCart();
      WebElement quantity = shop.productPage().quantity();
      wait.until(attributeToBe(quantity, "textContent", Integer.toString(quantityAfter)));
      assertThat(quantity.getAttribute("textContent"), equalTo(Integer.toString(quantityAfter)));
    }

    // переходим к корзину и удаляем товары
    shop.homePage().checkout();
    List<WebElement> items = shop.cart().orderedItemsQuantity();
    while (! items.isEmpty()) {
      if (isElementPresent(By.cssSelector(".shortcuts > li"))) {
        driver.findElements(By.cssSelector(".shortcuts > li")).get(0).click();
      }
      shop.cart().remove();
      wait.until(numberOfElementsToBeLessThan(By.cssSelector("#box-checkout-summary td.item"), items.size()));
      items = shop.cart().orderedItemsQuantity();
    }
    assertTrue(isElementNotPresent(By.id("#box-checkout-summary td.item")));
    assertThat(shop.cart().noItemsInYourCart().getAttribute("textContent"), equalTo("There are no items in your cart."));
  }
}
