package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BasicStepDefs {

    WebDriver driver =null;

    public void initializeDriver()
    {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }


 /*
 Basic feature steps
  */

    @Given("^\"([^\"]*)\" use Cucumber Main class to run tests$")
    public void I_use_Cucumber_Main_class_to_run_tests(String testString) throws Throwable {
        System.out.println("Hello cucumber jvm " + testString);
    }


    @Then("^Gradle should report \"([^\"]*)\"$")

    public void Gradle_should_report() throws Throwable {
        throw new PendingException();
    }
 /*
 Google feature steps
  */

    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
        initializeDriver();
        driver.get(page);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String search) throws Throwable {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(search);
        element.submit();
    }

    @Then("^a browser title should contains \"([^\"]*)\"$")
    public void a_browser_title_should_contains(String text) throws Throwable {
        Thread.sleep(1000);
        closeDriver();

    }

    private void closeDriver() {
        driver.quit();
    }

}
