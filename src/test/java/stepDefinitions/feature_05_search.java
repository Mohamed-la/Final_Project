package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class feature_05_search {
    ChromeDriver driver;
    //public static void main(String[] args) throws InterruptedException {
       @Given("user choose the required item to buy: books")
       public void user_click_item_likes_books() {

           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.navigate().to("https://demo.nopcommerce.com/");

           WebElement btn_search = driver.findElement(By.linkText("Books"));
           btn_search.click();
       }
       @When("user choose name of book")
       public void user_choose_name_of_book() {
           Select product = new Select(driver.findElement(By.id("products-orderby")));
           product.selectByIndex(3);

           Select page_size = new Select(driver.findElement(By.id("products-pagesize")));
           page_size.selectByIndex(0);

           WebElement book_name = driver.findElement(By.linkText("Pride and Prejudice"));
           String v = book_name.getAttribute("href");
           System.out.println("value of link: " + v);
       }

    @Then("quit from the website")
    public void quit_from_the_website() {

           driver.quit();
       }}

