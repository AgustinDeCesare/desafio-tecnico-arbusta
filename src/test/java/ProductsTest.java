import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsTest {
  private WebDriver driver;

  private JavascriptExecutor js;

  By logoLocator = By.xpath("//img[@alt=\"Website for automation practice\"]");
  By productsLocator = By.xpath("//*[@href=\"/products\"]");
  By allProductsLocator = By.xpath("//*[text()=\"All Products\"]");
  By productListLocator = By.className("features_items");

  By firstProductLocator = By.xpath("//*[@href=\"/product_details/1\"]");

  By nameLocator = By.xpath("//*[text()=\"Blue Top\"]");
  By categoryLocator = By.xpath("//*[text()=\"Category: Women > Tops\"]");
  By priceLocator = By.xpath("//*[text()=\"Rs. 500\"]");
  By availabilityLocator = By.xpath("//*[text()=\"Availability:\"]");
  By conditionLocator = By.xpath("//*[text()=\"Condition:\"]");
  By brandLocator = By.xpath("//*[text()=\"Brand:\"]");

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.automationexercise.com/");
    driver.manage().window().maximize();
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testProductos() {
    Actions action = new Actions(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(logoLocator).isDisplayed());

    action.click(driver.findElement(productsLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(allProductsLocator).isDisplayed());

    assertTrue(driver.findElement(productListLocator).isDisplayed());

    wait.until(ExpectedConditions.presenceOfElementLocated(firstProductLocator));

    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(firstProductLocator));

    action.moveToElement(driver.findElement(firstProductLocator)).click(driver.findElement(firstProductLocator)).perform();

    wait.until(ExpectedConditions.titleIs("Automation Exercise - Product Details"));

    assertTrue(driver.findElement(nameLocator).isDisplayed());
    assertTrue(driver.findElement(categoryLocator).isDisplayed());
    assertTrue(driver.findElement(priceLocator).isDisplayed());
    assertTrue(driver.findElement(availabilityLocator).isDisplayed());
    assertTrue(driver.findElement(conditionLocator).isDisplayed());
    assertTrue(driver.findElement(brandLocator).isDisplayed());

  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
