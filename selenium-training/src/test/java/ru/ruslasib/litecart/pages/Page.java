package test.java.ru.ruslasib.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page {

  private WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String inputText) {
    driver.findElement(locator).sendKeys(inputText);
  }

  public void clear(By locator) {
    driver.findElement(locator).clear();
  }

  public void checkRadioButton(By locator, String radioButtonValue, String textSource) {
    /**
     * radioButtonValue has two values:
     * textSource - name of attribute where is needed to take text to choose radio  button
     */
    List<WebElement> buttons = driver.findElements(locator);
    for (WebElement button : buttons) {
      if (button.getAttribute(textSource).equals(radioButtonValue) && button.getAttribute("checked") == null) {
        button.click();
        return;
      }
    }
  }

  public void chooseCheckbox(By locator, String folderName, String textSource) {
    List<WebElement> folders = driver.findElements(locator);
    for (WebElement folder : folders) {
      if ((folder.getAttribute(textSource).equals(folderName) && folder.getAttribute("checked") == null)
              || (folder.getAttribute("checked") != null)) {
        folder.click();
      }
    }
  }

  public void chooseElementFromDropbox(By locator, String elementName, String textSource) {
    List<WebElement> categories = driver.findElements(locator);
    for (WebElement category : categories) {
      if (category.getAttribute(textSource).equals(elementName)) {
        category.click();
        return;
      }
    }
  }
}
