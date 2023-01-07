
package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class feature_01_Register {
    ChromeDriver driver;


    @Given("user navigate to homepage")
    public void user_navigate_to_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @When("user click on register button")
   public  void click_register() {
        WebElement register = driver.findElement(By.className("ico-register"));
        register.click();
    }

    @And ("user entered valid user data")
    public void user_entered_user_data()  throws InterruptedException {
        WebElement gend = driver.findElement(By.id("gender-female"));
        gend.click();

        WebElement fname = driver.findElement(By.id("FirstName"));
        fname.sendKeys("yara ");

        WebElement lname = driver.findElement(By.id("LastName"));
        lname.sendKeys("osama");

        Select sel_day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        sel_day.selectByValue("15");

        Select sel_Month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        sel_Month.selectByIndex(3);

        Select sel_year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        sel_year.selectByValue("1995");

        WebElement emaill = driver.findElement(By.id("Email"));
        emaill.sendKeys("myara3@gmail.com");
        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("iti4");
        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("11111111");
        WebElement cpass = driver.findElement(By.id("ConfirmPassword"));
        cpass.sendKeys("11111111");
        WebElement registe = driver.findElement(By.id("register-button"));
        registe.click();
        Thread.sleep(2000);
    }

    @Then("registeration successfully")
    public void registeration_successfully() throws InterruptedException {
        WebElement continuss = driver.findElement(By.cssSelector("div[class=\"result\"]"));
       // System.out.println(continuss.isDisplayed());
        Assert.assertTrue(continuss.isDisplayed());

        Thread.sleep(5000);
        //driver.quit();
    }
    @And("user entered invalid user data")
    public void user_entered_invalid_user_data() throws InterruptedException {
        WebElement gend = driver.findElement(By.id("gender-female"));
        gend.click();

        WebElement fname = driver.findElement(By.id("FirstName"));
        fname.sendKeys("yara ");

        WebElement lname = driver.findElement(By.id("LastName"));
        lname.sendKeys("osama");

        Select sel_day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        sel_day.selectByValue("15");

        Select sel_Month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        sel_Month.selectByIndex(3);

        Select sel_year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        sel_year.selectByValue("1995");

        WebElement emaill = driver.findElement(By.id("Email"));
        emaill.sendKeys("saber4880@gmail.com");
        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("WE");
        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("11111111");
        WebElement cpass = driver.findElement(By.id("ConfirmPassword"));
        cpass.sendKeys("34111111");
        WebElement registe = driver.findElement(By.id("register-button"));
        registe.click();
        Thread.sleep(2000);
    }


    @Then("registeration failed")
    public void registeration_failed() {
        WebElement reg_btn = driver.findElement(By.name("register-button"));
        System.out.println(reg_btn.isDisplayed());

        Assert.assertEquals(reg_btn.isDisplayed(),true);
    }
}