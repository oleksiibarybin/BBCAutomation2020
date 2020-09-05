import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NewsPageTests {
    private String BASE_URL = "https://www.bbc.com";
    private String CHROMEDRIVER_LOCAL_PATH = "src\\main\\resources\\chromedriver.exe";

    private WebDriver driver;

    @BeforeTest
    public void suiteSetUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCAL_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get(BASE_URL);
    }

    @AfterTest
    public void suiteTearDown() {
        driver.close();
    }

    @Test
    public void checkNewsHeadlineArticleTitle() {
        driver.findElement(By.xpath("//a[@rev='news|header']")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//button[@data-bbc-title]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(@class,'gel-paragon-bold')]")));
        String mainTitle = driver.findElement(By.xpath("//h3[contains(@class,'gel-paragon-bold')]")).getText();
        assertEquals(mainTitle, "Trump panned over reports he mocked US military");
    }

    @Test
    public void checkNewsSecondaryTitles() {
        driver.findElement(By.xpath("//a[@rev='news|header']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(@class,'gel-pica-bold')]")));
        List<WebElement> secondaryTitlesElementsList = driver.findElements(By.xpath("//h3[contains(@class,'gel-pica-bold')]"));

        List<String> expectedSecondaryTitles = Arrays.asList(
                "Arrests at Australia anti-lockdown protests",
                "Professor who posed as black 'won't teach classes'",
                "Earth's 'lost species' only the tip of the iceberg",
                "Trump refuses to condemn Russia over Navalny",
                "Drone filmed dropping suspected cannabis over city",
                "North Korea to punish officials over typhoon");

        List<String> secondaryTitlesText = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            //System.out.println(secondaryTitlesElementsList.get(i).getText());
            secondaryTitlesText.add(secondaryTitlesElementsList.get(i).getText());
        }
        int index = 0;
        for (String title : secondaryTitlesText) {
            assertEquals(title, expectedSecondaryTitles.get(index));
            index++;
        }
    }

    @Test
    public void checkSearchResultsAgainstNewsHeadlineArticleCategoryLink() {
        driver.findElement(By.xpath("//a[@rev='news|header']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(@class,'gel-paragon-bold')]")));
        String newsHeadlineArticleCategoryLink = driver.findElement(By.xpath("//a[@aria-label]/span")).getText();

        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(newsHeadlineArticleCategoryLink, Keys.ENTER);
        List<WebElement> searchResultsMetadata = driver.findElements(By.xpath("//span[@type='category']"));
        String searchResultsFirsItemRegionMetadata = searchResultsMetadata.get(1).getText();
        String expectedFirsItemRegionMetadata = "US & Canada";

        assertEquals(searchResultsFirsItemRegionMetadata, expectedFirsItemRegionMetadata);
    }
}
