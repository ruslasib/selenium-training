package test.java.ru.ruslasib.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.tests.ParametersHolder;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Page {

  private WebDriver driver;
  protected WebDriverWait wait;

  public Page(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

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
     * textSource - inputName of attribute where is needed to take text to choose radio  button
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

  public void inputDate(By locator, String date) {
    Actions action = new Actions(driver);
    System.out.println(date.replaceAll("^0-9", ""));
    action.moveToElement(driver.findElement(locator))
            .moveByOffset(11, 11)
            .click()
            .sendKeys(date.replaceAll("/", ""))
            .perform();
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      return driver.findElements(locator).size() > 0;
    } finally {
      driver.manage().timeouts().implicitlyWait(ParametersHolder.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
  }

  public void select(By locator, String selectedOption) {
    new Select(driver.findElement(locator)).selectByVisibleText(selectedOption);
  }
}
