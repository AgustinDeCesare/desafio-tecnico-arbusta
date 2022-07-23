import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginUserTest {
  private WebDriver driver;

  By logoLocator = By.xpath("//img[@alt=\"Website for automation practice\"]");
  By loginLinkLocator = By.xpath("//*[@href=\"/login\"]");
  By loginToYourAccountLocator = By.xpath("//*[text()=\"Login to your account\"]");

  By emailAddressLocator = By.xpath("//input[@data-qa=\"login-email\"]");
  By passwordLocator = By.xpath("//input[@data-qa=\"login-password\"]");
  By loginButtonLocator = By.xpath("//button[@data-qa=\"login-button\"]");

  By usernameLocator = By.xpath("//*[text()=\"Agustin\"]");
  By deleteAccountLocator = By.xpath("//*[@href=\"/delete_account\"]");

  By accountDeletedLocator = By.xpath("//*[text()=\"Account Deleted!\"]");
  By continueButtonLocator = By.xpath("//*[@data-qa=\"continue-button\"]");

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.automationexercise.com/");
    driver.manage().window().maximize();
  }

  @Test
  public void testLogin() throws InterruptedException {
    Actions action = new Actions(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(logoLocator).isDisplayed());


    action.click(driver.findElement(loginLinkLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


    assertTrue(driver.findElement(loginToYourAccountLocator).isDisplayed());


    driver.findElement(emailAddressLocator).sendKeys("asdasdasdasdad@gmail.com");
    driver.findElement(passwordLocator).sendKeys("password");
    action.click(driver.findElement(loginButtonLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


    assertTrue(driver.findElement(usernameLocator).isDisplayed());

    action.click(driver.findElement(deleteAccountLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    assertTrue(driver.findElement(accountDeletedLocator).isDisplayed());

    action.click(driver.findElement(continueButtonLocator)).perform();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
