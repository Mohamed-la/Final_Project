package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.cucumber.junit.cucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class feature_02_Login {

    ChromeDriver driver;

    @Given("user click on login button")
    public void user_click_on_login_button() {

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");

        WebElement use_test = driver.findElement(By.className("ico-login"));
        use_test.click();

      //  throw new io.cucumber.java.PendingException();
    }

    @When("entered user valid data")
    public void user_entered_valid_user_data() throws InterruptedException {
        Thread.sleep(3000);
        WebElement email_user = driver.findElement(By.id("Email"));
        // email_user.clear();
        email_user.sendKeys("yarasaber48@gmail.com");
        WebElement pass_user = driver.findElement(By.id("Password"));
        // email_user.clear();
        pass_user.sendKeys("11111111");


    //    throw new io.cucumber.java.PendingException();
    }

    @Then("Login successfully")
    public void login_successfully() {

        WebElement login_user = driver.findElement(By.className("login-button"));
        login_user.click();
        Assert.assertTrue(driver.findElement(By.className("login-button")).isDisplayed());
      //    throw new io.cucumber.java.PendingException();
    }
    @When("entered user invalid data")
    public void user_entered_user_invalid_data() {
        WebElement email_user = driver.findElement(By.id("Email"));
        // email_user.clear();
        email_user.sendKeys("uuii");
        WebElement pass_user = driver.findElement(By.id("Password"));
        // email_user.clear();
        pass_user.sendKeys("11111111");

    }
    @Then("Login failed")
    public void login_failed() {
        WebElement login_user = driver.findElement(By.className("login-button"));
        login_user.click();

        Assert.assertTrue(driver.findElement(By.id("Email-error")).isDisplayed());
    }
}