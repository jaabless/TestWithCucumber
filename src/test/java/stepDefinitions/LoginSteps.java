package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should be redirected to the products page")
    public void the_user_should_be_redirected_to_the_products_page() {
        String title = driver.findElement(By.className("title")).getText();
        assertEquals("Products", title);
        driver.quit();
    }
}
