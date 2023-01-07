package stepDefinitions;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class feature_04_Add_To_Cart {
    ChromeDriver driver;
    @Given("user navigate to the website")
    public void user_navigate_to_thewebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user use action hovar")
    public void user_use_action_hovar() throws InterruptedException {
        Actions hanovr = new Actions(driver);
        hanovr.moveToElement(driver.findElement(By.cssSelector("a[href=\"/computers\"]"))).perform();

        String S1 = driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).getText();
  //      System.out.println(S1);
        driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
        Thread.sleep(2000);

        WebElement ss = driver.findElement(By.linkText("Build your own computer"));
        ss.click();

        Select sel = new Select(driver.findElement(By.id("product_attribute_2")));
        sel.selectByIndex(1);

        WebElement check = driver.findElement(By.id("product_attribute_3_6"));
        check.click();

        WebElement ADD_TO_CART = driver.findElement(By.id("add-to-cart-button-1"));
        ADD_TO_CART.click();
        Thread.sleep(2000);
    }

     @Then("test the bar color green")
        public void test_the_bar_colorGreen() {
       // String s = driver.findElement(By.className("bar-notification")).getCssValue("background-color");
    // convert rgba to hex
         WebElement content_bar = driver.findElement(By.className("content"));

           WebElement bar_notic = driver.findElement(By.className("bar-notification"));
           String s =bar_notic.getCssValue("background-color");
               String c = Color.fromString(s).asHex();

         Assert.assertTrue(c.contains("4bb07a"));
                driver.quit();
    }

    @ When ("user use action hovar invalid")
    public void user_use_action_hovar_invalid() throws InterruptedException {
        Actions hanovr = new Actions(driver);
        hanovr.moveToElement(driver.findElement(By.cssSelector("a[href=\"/computers\"]"))).perform();

        String S1 = driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).getText();
        //      System.out.println(S1);
        driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
        Thread.sleep(2000);

        WebElement ss = driver.findElement(By.linkText("Build your own computer"));
        ss.click();

       // Select sel = new Select(driver.findElement(By.id("product_attribute_2")));
        //sel.selectByIndex(1);

        WebElement check = driver.findElement(By.id("product_attribute_3_6"));
        check.click();

        WebElement ADD_TO_CART = driver.findElement(By.id("add-to-cart-button-1"));
        ADD_TO_CART.click();
        Thread.sleep(2000);
    }
    @Then("test the bar color red")
    public void test_the_bar_colorRed()
    {
        WebElement content_bar = driver.findElement(By.className("content"));

        WebElement bar_notic = driver.findElement(By.className("bar-notification"));
        String s =bar_notic.getCssValue("background-color");
        String c = Color.fromString(s).asHex();
//                System.out.println("Color is :" + s);
//                System.out.println("Hex code for color:" + c);
//                System.out.println(content_bar.getText());
        Assert.assertTrue(c.contains("#e4444c"));
        driver.quit();
    }



}