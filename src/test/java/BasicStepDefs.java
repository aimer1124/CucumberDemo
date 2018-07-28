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

    @Given("^用户打开百度搜索页面$")
    public void open_Baidu_searchPage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        driver = new ChromeDriver();
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
        driver.quit();

    }

}
