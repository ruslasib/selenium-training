package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.model.Product;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewProductTests extends TestBase {

  @BeforeClass
  public void prepare() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test(dataProvider = "testNewProductAddition", dataProviderClass = DataProvider.class)
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
    assertThat(litecartAdmin.editProduct().nameFieldValue(), equalTo(duck.getName()));
    assertThat(litecartAdmin.editProduct().codeFieldValue(), equalTo(duck.getCode()));
  }
}
