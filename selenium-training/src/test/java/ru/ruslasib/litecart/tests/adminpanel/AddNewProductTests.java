package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.model.Product;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static test.java.ru.ruslasib.Helper.generateCode;
import static test.java.ru.ruslasib.Helper.generateName;

public class AddNewProductTests extends TestBase {

  @DataProvider(name = "testNewProductAddition")
  public Iterator<Object[]> productData() {
    List<Object[]> products = new ArrayList<>();
    products.add(new Product[]{new Product()
            .withName(generateName())
            .withCode(generateCode())
            .withStatus("enabled")
            .withCategory("Rubber Ducks")
            .withGender("male")
            .withQuantity(3)
            .withQuantityUnit("pcs")
            .withDeliveryStatus("3-5 days")
            .withSoldOutStatus("Temporary sold out")
            .withImageIn("\\selenium-training\\src\\test\\java\\ru\\ruslasib\\resource\\duck.jpg")
            .withDateValidFrom("01/11/2020")
            .withDateValidTo("31/10/2021")
            .withManufacturer("ACME Corp.")
            .withKeywords("keywords about super duck")
            .withShortDescription("short description of super duck")
            .withDescription("description of super duck")
            .withHeadTitle("head title of super duck")
            .withMetaDescription("meta description of super duck")
            .withPurchasePrice(12)
            .withCurrency("EUR")
            .withPriceUSD(17)
            .withPriceEUR(15)});
    return products.iterator();
  }

  @BeforeClass
  public void prepare() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test(dataProvider = "testNewProductAddition")
  public void testNewProductAddition(Product duck) {
    litecartAdmin.leftMenu().catalog();
    litecartAdmin.catalog().addNewProduct();
    litecartAdmin.addNewProduct().general().checkStatusRadioButton(duck.getStatus());
    litecartAdmin.addNewProduct().general().inputName(duck.getName());
    litecartAdmin.addNewProduct().general().inputCode(duck.getCode());
    litecartAdmin.addNewProduct().general().chooseCategoryCheckbox(duck.getCategory());
    litecartAdmin.addNewProduct().general().selectDefaultCategory(duck.getCategory());
    litecartAdmin.addNewProduct().general().chooseGender(duck.getGender());
    litecartAdmin.addNewProduct().general().inputQuantity(duck.getQuantity());
    litecartAdmin.addNewProduct().general().selectQuantityUnit(duck.getQuantityUnit());
    litecartAdmin.addNewProduct().general().selectDeliveryStatus(duck.getDeliveryStatus());
    litecartAdmin.addNewProduct().general().selectSoldOutStatus(duck.getSoldOutStatus());
    litecartAdmin.addNewProduct().general().uploadFiles(duck.getImage());
    litecartAdmin.addNewProduct().general().inputDateValidFrom(duck.getDateValidFrom());
    litecartAdmin.addNewProduct().general().inputDateValidTo(duck.getDateValidTo());

    litecartAdmin.addNewProduct().informationTab();
    litecartAdmin.addNewProduct().information().selectManufacturer(duck.getManufacturer());
    litecartAdmin.addNewProduct().information().inputKeywords(duck.getKeywords());
    litecartAdmin.addNewProduct().information().inputShortDescription(duck.getShortDescription());
    litecartAdmin.addNewProduct().information().inputDescription(duck.getDescription());
    litecartAdmin.addNewProduct().information().inputHeadTitle(duck.getHeadTitle());
    litecartAdmin.addNewProduct().information().inputMetaDescription(duck.getMetaDescription());

    litecartAdmin.addNewProduct().pricesTab();
    litecartAdmin.addNewProduct().prices().inputPurchasePrice(duck.getPurchasePrice());
    litecartAdmin.addNewProduct().prices().selectCurrency(duck.getCurrency());
    litecartAdmin.addNewProduct().prices().inputPriceUSD(duck.getPriceUSD());
    litecartAdmin.addNewProduct().prices().inputPriceEUR(duck.getPriceEUR());
    litecartAdmin.submitPanel().save();

    litecartAdmin.catalog().chooseProduct(duck.getName());
    assertThat(litecartAdmin.editProduct().name(), equalTo(duck.getName()));
    assertThat(litecartAdmin.editProduct().code(), equalTo(duck.getCode()));
  }
}
