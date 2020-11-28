package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.Helper;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AddNewProductTests extends TestBase {

  @BeforeClass
  public void prepare() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testNewProductAddition() {
    String productName = Helper.generateName();
    String productCode = Helper.generateCode();
    String defaultCategory = "Rubber Ducks";
    litecartAdmin.leftMenu().catalog();
    litecartAdmin.catalog().addNewProduct();
    litecartAdmin.addNewProduct().general().checkStatusRadioButton("0");
    litecartAdmin.addNewProduct().general().inputName(productName);
    litecartAdmin.addNewProduct().general().inputCode(productCode);
    litecartAdmin.addNewProduct().general().chooseCategoryCheckbox(defaultCategory);
    litecartAdmin.addNewProduct().general().selectDefaultCategory(defaultCategory);
    litecartAdmin.addNewProduct().general().chooseGender("1-1");
    litecartAdmin.addNewProduct().general().inputQuantity("3");
    litecartAdmin.addNewProduct().general().selectQuantityUnit("pcs");
    litecartAdmin.addNewProduct().general().selectDeliveryStatus("3-5 days");
    litecartAdmin.addNewProduct().general().selectSoldOutStatus("Temporary sold out");
    litecartAdmin.addNewProduct().general().uploadFiles("\\selenium-training\\src\\test\\java\\ru\\ruslasib\\resources\\duck.jpg");
    litecartAdmin.addNewProduct().general().inputDateValidFrom("01/11/2020");
    litecartAdmin.addNewProduct().general().inputDateValidTo("31/10/2021");

    litecartAdmin.addNewProduct().informationTab();
    wait.until(presenceOfElementLocated(By.name("manufacturer_id")));
    litecartAdmin.addNewProduct().information().selectManufacturer("ACME Corp.");
    litecartAdmin.addNewProduct().information().inputKeywords("keywords about super duck");
    litecartAdmin.addNewProduct().information().inputShortDescription("short description of super duck");
    litecartAdmin.addNewProduct().information().inputDescription("description of super duck");
    litecartAdmin.addNewProduct().information().inputHeadTitle("head title of super duck");
    litecartAdmin.addNewProduct().information().inputMetaDescription("meta description of super duck");

    litecartAdmin.addNewProduct().pricesTab();
    wait.until(presenceOfElementLocated(By.id("tab-prices")));
    litecartAdmin.addNewProduct().prices().inputPurchasePrice("12");
    litecartAdmin.addNewProduct().prices().selectCurrency("EUR");
    litecartAdmin.addNewProduct().prices().inputPriceUSD("17");
    litecartAdmin.addNewProduct().prices().inputPriceEUR("15");
    litecartAdmin.addNewProduct().prices().save();

    litecartAdmin.catalog().chooseProduct(productName);
    assertThat(litecartAdmin.editProduct().name(), equalTo(productName));
    assertThat(litecartAdmin.editProduct().code(), equalTo(productCode));
  }
}
