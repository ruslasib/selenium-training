package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountriesTests extends TestBase {

  @BeforeClass
  public void init() {
    super.openAdminPanel();
    litecartAdmin.homePage().countries();
  }

  @Test
  public void testCountriesArrangement() {
    List<WebElement> rows = litecartAdmin.countries().countriesRows();
    List<String> countriesNames = new ArrayList<>();
    for (WebElement row : rows) {
      countriesNames.add(row.findElement(By.cssSelector("td:nth-of-type(5)")).getAttribute("textContent"));
    }
    List<String> countriesNamesSorted = new ArrayList<>(countriesNames);
    countriesNamesSorted.sort(Comparator.naturalOrder());
    assertThat(countriesNamesSorted, equalTo(countriesNames));
  }
}
