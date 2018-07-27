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

import static junit.framework.TestCase.assertTrue;


public class BasicStepDefs {

    WebDriver driver =null;

    public void initializeDriver()
    {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
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
 Baidu feature steps
  */

    @Given("^用户打开百度搜索页面$")
    public void open_Baidu_page() throws Throwable {
        initializeDriver();
        driver.get("https://www.baidu.com");
    }

    @When("^在搜索框中搜索行为驱动开发$")
    public void search_content() throws Throwable {
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("行为驱动开发");
        element.submit();
    }

    @Then("^浏览器标题中包含行为驱动开发$")
    public void browser_title_should_contains_searchContent() throws Throwable {
        Thread.sleep(1000);
        assertTrue(driver.getTitle().contains("行为驱动开发"));
        closeDriver();

    }

    private void closeDriver() {
        driver.quit();
    }

}
