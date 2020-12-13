package test.java.ru.ruslasib.litecart.tests.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;
import test.java.ru.ruslasib.litecart.tests.adminpanel.StaticDataProvider;

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

  @Test(dataProvider = "quantityOfProducts", dataProviderClass = StaticDataProvider.class)
  public void testAddToAndRemoveFromCart(int productsQuantity) {
    // добавляем товары в корзину
    for (int i = 0; i < productsQuantity; i++) {
      shop.homePage().goToHomePage();
      shop.homePage().addToCartFirstMostPopularProduct();
      shop.productPage().selectSize();
      int quantityAfter = shop.cart().quantityValue() + 1;
      shop.productPage().addToCartButton();
      WebElement quantity = shop.cart().quantity();
      wait.until(attributeToBe(quantity, "textContent", Integer.toString(quantityAfter)));
      assertThat(quantity.getAttribute("textContent"), equalTo(Integer.toString(quantityAfter)));
    }

    // переходим к корзину и удаляем товары
    shop.cart().checkoutButton();
    shop.productPage().removeAllProductsFromCart();
    assertTrue(isElementNotPresent(shop.productPage().allOrderedItems()));
    assertThat(shop.cart().noItemsInYourCartText(), equalTo("There are no items in your cart."));
  }
}
