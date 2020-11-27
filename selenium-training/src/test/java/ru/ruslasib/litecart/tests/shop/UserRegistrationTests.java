package test.java.ru.ruslasib.litecart.tests.shop;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.Helper;
import test.java.ru.ruslasib.litecart.tests.TestBase;

public class UserRegistrationTests extends TestBase {

  @BeforeClass
  public void launch() {
    shop.launch("https://litecart.stqa.ru/en/");
  }

  @Test
  public void testUserRegistration() {
    String email = Helper.generateEmail();
    String password = "123456";
    shop.homePage().createAccount();
    shop.createAccount().inputFirstName("FirstName");
    shop.createAccount().inputLastName("LastName");
    shop.createAccount().inputAddress1("Address1");
    shop.createAccount().inputPostcode("12345");
    shop.createAccount().inputCity("City");
    shop.createAccount().chooseCountry("United States");
    shop.createAccount().chooseState("Texas");
    shop.createAccount().inputEmail(email);
    shop.createAccount().inputPhone("+79991234567");
    shop.createAccount().inputDesiredPassword(password);
    shop.createAccount().inputConfirmPassword(password);
    shop.createAccount().createAccount();

    shop.homePage().logout();
    shop.homePage().inputEmail(email);
    shop.homePage().inputPassword(password);
    shop.homePage().loginButton();

    shop.homePage().logout();

  }
}
