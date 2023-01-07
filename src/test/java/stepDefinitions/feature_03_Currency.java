package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class feature_03_Currency {
    ChromeDriver driver;
        @Given("user open the website home page")
        public void user_click_on_coins() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();
        }

        @When("User chooses Euro currency")
        public void choose_Euro() {
            Select optionss = new Select(driver.findElement(By.id("customerCurrency")));
            optionss.selectByIndex(1);
        }
    @When("User chooses Dollar currency")
    public void choose_Dollar()
    {
        Select optionss = new Select(driver.findElement(By.id("customerCurrency")));
        optionss.selectByIndex(0);
    }
        @Then("Check that Euro is selected successfully")
        public void checkEuro() throws InterruptedException {
            Assert.assertTrue(driver.findElement(By.id("customerCurrency")).getText().contains("Euro"));
            Thread.sleep(3000);
            driver.quit();
        }
    @Then("Check that Dollar is selected successfully")
    public void CheckDollar() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.id("customerCurrency")).getText().contains("Dollar"));
        Thread.sleep(3000);
        driver.quit();
    }

}




