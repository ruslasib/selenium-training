package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

public class AddNewProductTests extends TestBase {

  @BeforeClass
  public void prepare() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testNewProductAddition() {
    litecartAdmin.leftMenu().catalog();
    litecartAdmin.catalog().addNewProduct();
    litecartAdmin.addNewProduct().general().checkStatusRadioButton("0");
    litecartAdmin.addNewProduct().general().name("Super Duck");
    litecartAdmin.addNewProduct().general().code("666");
    litecartAdmin.addNewProduct().general().chooseCategoryCheckbox("Rubber Ducks");
    litecartAdmin.addNewProduct().general().chooseDefaultCategory("Rubber Ducks");
    litecartAdmin.addNewProduct().general().chooseGender("1-1");
    litecartAdmin.addNewProduct().general().inputQuantity("3");
    litecartAdmin.addNewProduct().general().chooseQuantityUnit("pcs");
    litecartAdmin.addNewProduct().general().chooseDeliveryStatus("3-5 days");
    litecartAdmin.addNewProduct().general().chooseSoldOutStatus("Temporary sold out");
    litecartAdmin.addNewProduct().general().uploadFiles("\\selenium-training\\src\\test\\java\\ru\\ruslasib\\resources\\duck.jpg");
    // не получается ввести дату
    litecartAdmin.addNewProduct().general().inputDateValidFrom("01.11.2020");
    litecartAdmin.addNewProduct().general().inputDateValidTo("31.10.2021");

  }
}
