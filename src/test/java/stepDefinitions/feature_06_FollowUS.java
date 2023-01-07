package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class feature_06_FollowUS {

        ChromeDriver driver;

        @Given("user navigate to website")
        public void user_navigate_to_website() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                driver.navigate().to("https://demo.nopcommerce.com/");
                driver.manage().window().maximize();
        }

        @When("user click on follow us facebook")
        public void user_clickon_follow_us_facebook() throws InterruptedException {
                WebElement face = driver.findElement(By.linkText("Facebook"));
                face.click();
                Thread.sleep(2000);
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                System.out.println(tabs.size());
                driver.switchTo().window(tabs.get(1));
        }

        @When("user click on follow us twitter")
        public void user_clickon_follow_us_twitter() throws InterruptedException {
                WebElement twiter = driver.findElement(By.linkText("Twitter"));
                twiter.click();
                ArrayList<String> tabs_two = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs_two.get(1));
        }

        @Then("FB follow done successfully")
        public void FB_process_scuccefully() {
               // System.out.println(driver.findElement(By.className("x1n2onr6")).isDisplayed());
                Assert.assertTrue((driver.findElement(By.className("x1n2onr6")).getText().contains("Facebook")));
                driver.quit();

        }

        @Then("twitter follow done successfully")
        public void twitter_process_scuccefully() throws InterruptedException {
                Thread.sleep(3000);

                Assert.assertTrue((driver.findElement(By.className("css-901oao")).isDisplayed()));
                driver.quit();
        }
}