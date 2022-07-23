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

import static org.junit.Assert.assertTrue;

public class ContactUsTest {
  private WebDriver driver;

  By logoLocator = By.xpath("//img[@alt=\"Website for automation practice\"]");
  By contactUsLocator = By.xpath("//*[@href=\"/contact_us\"]");
  By getInTouchLocator = By.xpath("//*[text()=\"Get In Touch\"]");

  By nameLocator = By.name("name");
  By emailAddressLocator = By.name("email");
  By subjectLocator = By.name("subject");
  By messageLocator = By.name("message");
  By uploadFileLocator = By.name("upload_file");
  By contactFormLocator = By.name("contact-form");

  By messageSubmittedLocator = By.xpath("//*[text()=\"Success! Your details have been submitted successfully.\"]");

  By homeButtonLocator = By.xpath("//*[text()=\" Home\"]");

  String basePath = new File("").getAbsolutePath();

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.automationexercise.com/");
    driver.manage().window().maximize();
  }

  @Test
  public void testContacto() {
    Actions action = new Actions(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(logoLocator).isDisplayed());

    action.click(driver.findElement(contactUsLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(getInTouchLocator).isDisplayed());

    driver.findElement(nameLocator).sendKeys("Agustin");
    driver.findElement(emailAddressLocator).sendKeys("asdasdasdasdad@gmail.com");
    driver.findElement(subjectLocator).sendKeys("Asunto");
    driver.findElement(messageLocator).sendKeys("Mensaje");
    driver.findElement(uploadFileLocator).sendKeys(basePath + "\\src\\test\\resources\\fileToSubmit.txt");

    driver.findElement(contactFormLocator).submit();

    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(messageSubmittedLocator).isDisplayed());

    action.click(driver.findElement(homeButtonLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(homeButtonLocator).isDisplayed());
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
