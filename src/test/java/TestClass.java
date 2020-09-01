import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void checkSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe"); // set up path to the chromedriver
        WebDriver chromeDriver = new ChromeDriver(); // Creates a new Chrome instance
        chromeDriver.get("https://www.bbc.com"); // Navigates to a page by address
    }
}
