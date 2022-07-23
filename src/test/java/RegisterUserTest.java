import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class RegisterUserTest {
  private WebDriver driver;

  By logoLocator = By.xpath("//img[@alt=\"Website for automation practice\"]");
  By signUpLinkLocator = By.xpath("//*[@href=\"/login\"]");
  By newUserSignUpLocator = By.xpath("//*[text()=\"New User Signup!\"]");

  By nameLocator = By.xpath("//input[@data-qa=\"signup-name\"]");
  By emailAddressLocator = By.xpath("//input[@data-qa=\"signup-email\"]");
  By signUpButtonLocator = By.xpath("//button[@data-qa=\"signup-button\"]");

  By enterAccountInformationLocator = By.xpath("//*[text()=\"Enter Account Information\"]");

  By genderLocator = By.id("id_gender1");

  By passwordLocator = By.id("password");

  By daysLocator = By.id("days");
  By monthsLocator = By.id("months");
  By yearsLocator = By.id("years");


  By newsletterLocator = By.id("newsletter");
  By specialOffersLocator = By.id("optin");

  By firstNameLocator = By.id("first_name");
  By lastNameLocator = By.id("last_name");
  By companyLocator = By.id("company");
  By address1Locator = By.id("address1");
  By address2Locator = By.id("address2");
  By countryLocator = By.id("country");
  By stateLocator = By.id("state");
  By cityLocator = By.id("city");
  By zipLocator = By.id("zipcode");
  By mobileNumberLocator = By.id("mobile_number");
  By createAccountLocator = By.xpath("//*[@data-qa=\"create-account\"]");


  By accountCreatedLocator = By.xpath("//*[text()=\"Account Created!\"]");
  By continueButtonLocator = By.xpath("//*[@data-qa=\"continue-button\"]");

  By usernameLocator = By.xpath("//*[text()=\"Agustin\"]");
  By deleteAccountLocator = By.xpath("//*[@href=\"/delete_account\"]");

  By accountDeletedLocator = By.xpath("//*[text()=\"Account Deleted!\"]");


  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.automationexercise.com/");
    driver.manage().window().maximize();
  }

  @Test
  public void testRegistro() throws InterruptedException {
    Actions action = new Actions(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    try{
    assertTrue(driver.findElement(logoLocator).isDisplayed());
    } catch (NoSuchElementException e) {
      System.out.println("Elemento no encontrado");
    }

    action.click(driver.findElement(signUpLinkLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    try{
    assertTrue(driver.findElement(newUserSignUpLocator).isDisplayed());
    } catch (NoSuchElementException e) {
      System.out.println("Elemento no encontrado");
    }

    driver.findElement(nameLocator).sendKeys("Agustin");
    driver.findElement(emailAddressLocator).sendKeys("asdasdasdasdad@gmail.com");
    action.click(driver.findElement(signUpButtonLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    try{
    assertTrue(driver.findElement(enterAccountInformationLocator).isDisplayed());
    } catch (NoSuchElementException e) {
      System.out.println("Elemento no encontrado");
    }

    driver.findElement(genderLocator).click();

    driver.findElement(passwordLocator).sendKeys("password");
    Select dropDays = new Select(driver.findElement(daysLocator));
    dropDays.selectByValue("9");
    Select dropMonths = new Select(driver.findElement(monthsLocator));
    dropMonths.selectByValue("12");
    Select dropYears = new Select(driver.findElement(yearsLocator));
    dropYears.selectByValue("2018");

    driver.findElement(newsletterLocator).click();
    driver.findElement(specialOffersLocator).click();

    driver.findElement(firstNameLocator).sendKeys("Agustin");
    driver.findElement(lastNameLocator).sendKeys("De Cesare");
    driver.findElement(companyLocator).sendKeys("Company");
    driver.findElement(address1Locator).sendKeys("Calle 123");
    driver.findElement(address2Locator).sendKeys("Calle 456");
    Select dropCountry = new Select(driver.findElement(countryLocator));
    dropCountry.selectByValue("Canada");
    driver.findElement(stateLocator).sendKeys("Estado");
    driver.findElement(cityLocator).sendKeys("Ciudad");
    driver.findElement(zipLocator).sendKeys("12345");
    driver.findElement(mobileNumberLocator).sendKeys("12345678");
    action.click(driver.findElement(createAccountLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    try{
    assertTrue(driver.findElement(accountCreatedLocator).isDisplayed());
    } catch (NoSuchElementException e) {
      System.out.println("Elemento no encontrado");
    }

    action.click(driver.findElement(continueButtonLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    try {
      assertTrue(driver.findElement(usernameLocator).isDisplayed());
    } catch (NoSuchElementException e) {
      System.out.println("Elemento no encontrado");
    }
    action.click(driver.findElement(deleteAccountLocator)).perform();

    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    try {
      assertTrue(driver.findElement(accountDeletedLocator).isDisplayed());
    } catch (NoSuchElementException e) {
      System.out.println("Elemento no encontrado");
    }

    action.click(driver.findElement(continueButtonLocator)).perform();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
