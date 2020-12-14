package test.java.ru.ruslasib.litecart.tests.shop;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.StaticDataProvider;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class AddToCartTests extends TestBase {

  @BeforeClass
  public void launch() {
    shop.launch("https://litecart.stqa.ru/en/");
    shop.homePage().login("ruslan@ruslan.ru", "123456");
  }

  @Test(dataProvider = "quantityOfProducts", dataProviderClass = StaticDataProvider.class)
  public void testAddToAndRemoveFromCart(int productsQuantity) {
    shop.addProductsToCartInAmountOf(productsQuantity);
    shop.cart().checkoutButton();
    shop.productPage().removeAllProductsFromCart();
    assertTrue(isElementNotPresent(shop.productPage().allOrderedItems()));
    assertThat(shop.productPage().noItemsInYourCartText(), equalTo("There are no items in your cart."));
  }
}
