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
    // добавляем первый товар
    shop.homePage().mostPopularItems().get(0).click();
    shop.productPage().selectSize();
    int quantityBefore = Integer.parseInt(shop.productPage().quantity().getAttribute("textContent"));
    int quantityAfter = quantityBefore + 1;
    shop.productPage().addToCart();
    WebElement quantity = shop.productPage().quantity();
    wait.until(attributeToBe(quantity, "textContent", Integer.toString(quantityAfter)));
    assertThat(quantity.getAttribute("textContent"), equalTo(Integer.toString(quantityAfter)));

    // добавляем второй товар
    shop.homePage().goToHomePage();
    shop.homePage().mostPopularItems().get(0).click();
    shop.productPage().selectSize();
    quantityBefore = Integer.parseInt(shop.productPage().quantity().getAttribute("textContent"));
    quantityAfter = quantityBefore + 1;
    shop.productPage().addToCart();
    quantity = shop.productPage().quantity();
    wait.until(attributeToBe(quantity, "textContent", Integer.toString(quantityAfter)));
    assertThat(quantity.getAttribute("textContent"), equalTo(Integer.toString(quantityAfter)));

    // добавляем третий товар
    shop.homePage().goToHomePage();
    shop.homePage().mostPopularItems().get(0).click();
    shop.productPage().selectSize();
    quantityBefore = Integer.parseInt(shop.productPage().quantity().getAttribute("textContent"));
    quantityAfter = quantityBefore + 1;
    shop.productPage().addToCart();
    quantity = shop.productPage().quantity();
    wait.until(attributeToBe(quantity, "textContent", Integer.toString(quantityAfter)));
    assertThat(quantity.getAttribute("textContent"), equalTo(Integer.toString(quantityAfter)));

    // переходим к корзину и удалаем первый товар
    shop.homePage().checkout();
    List<WebElement> before = shop.cart().orderedItemsQuantity();
    shop.cart().remove();
    wait.until(numberOfElementsToBeLessThan(By.cssSelector("#box-checkout-summary td.item"), before.size()));

    // удаляем второй товар
    before = shop.cart().orderedItemsQuantity();
    shop.cart().remove();
    wait.until(numberOfElementsToBeLessThan(By.cssSelector("#box-checkout-summary td.item"), before.size()));

    // удаляем третрий товар
    shop.cart().remove();
    assertTrue(isElementNotPresent(By.id("#box-checkout-summary td.item")));
  }
}
