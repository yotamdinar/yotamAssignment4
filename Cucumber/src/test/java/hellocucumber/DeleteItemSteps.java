package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import java.time.Duration;
import static junit.framework.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteItemSteps {

    private ChromeDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\dyota\\Desktop\\qaNEW\\Selenium\\chrome-browser\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dyota\\Desktop\\qaNEW\\Selenium\\chromedriver.exe");

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Given("User is in login page for admins")
    public void userIsInLoginPageForAdmins() {
        driver.get("http://localhost/opencartsite/yotam/");
        driver.manage().window().setPosition(new Point(300, 5));
    }

    @When("Admin is logged in with {string} and {string}")
    public void admin_login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-username']"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("User deletes a {string} from the store")
    public void delete(String profuct){
        driver.findElement(By.xpath("//*[@id='menu-catalog']/a[1]")).click();
        driver.findElement(By.xpath("//*[@id='collapse-1']/li[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id='form-product']/div[1]/table[1]/tbody[1]/tr[4]/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/div[1]/button[3]/i[1]")).click();


        

    }

    @Then("{string} should no longer be available in the products list")
    public void should_no_longer_be_available_in_the_products_list(String string) {
        //my account
        driver.findElement(By.xpath("//*[@id='top']/div[1]/div[2]/ul[1]/li[2]/div[1]/a[1]/span[1]")).click();
        //login-page
        driver.findElement(By.xpath("//*[@id='top']/div[1]/div[2]/ul[1]/li[2]/div[1]/ul[1]/li[2]/a[1]")).click();

        //login with dinaryo@post.bgu.ac.il and 1111
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-email']"))).sendKeys("dinaryo@post.bgu.ac.il");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys("1111");
        driver.findElement(By.xpath("//*[@id='form-login']/div/button[1]")).click();

        //search "iMac"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search']/input[1]"))).sendKeys("iMac");
        driver.findElement(By.xpath("//*[@id='search']/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-search']"))).sendKeys("iMac");
        driver.findElement(By.xpath("//*[@id='button-search']")).click();

        WebElement products_meeting_search = driver.findElement(By.xpath("//*[@id='content']/p[1]"));
        String text = products_meeting_search.getText();     
        
        assertEquals(text, 1, "There is no product that matches the search criteria.");

        
        

    }



    // @Given("User is on the Store Page")
    // public void user_is_on_the_store_page() {
    //     // Write code here that turns the phrase above into concrete actions
    //     throw new io.cucumber.java.PendingException();
    // }
    // @When("User tries to add {string} to the cart")
    // public void user_tries_to_add_to_the_cart(String string) {
    //     // Write code here that turns the phrase above into concrete actions
    //     throw new io.cucumber.java.PendingException();
    // }
    // @Then("User should see a message {string}")
    // public void user_should_see_a_message(String string) {
    //     // Write code here that turns the phrase above into concrete actions
    //     throw new io.cucumber.java.PendingException();
    // }

   
}
