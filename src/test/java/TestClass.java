import com.sun.org.apache.xerces.internal.xs.StringList;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestClass {
    private WebDriver chromeDriver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.bbc.com");
    }

    @AfterMethod
    public void tearDown() {
        chromeDriver.close();
    }

    @Test
    public void checkNewsHeadlineArticleTitle() {
        chromeDriver.findElement(By.xpath("//a[contains(@rev,'news|header')]")).click();
        new WebDriverWait(chromeDriver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        chromeDriver.findElement(By.xpath("//button[@data-bbc-title]")).click();

        WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(@class,'gs-c-promo-heading__title')]")));
        String mainTitle = chromeDriver.findElement(By.xpath("//h3[contains(@class,'gs-c-promo-heading__title')]")).getText();
        assertEquals(mainTitle, "Kenosha mayor 'a fool who backs anarchists' - Trump");
    }

    @Test
    public void checkNewsSecondaryTitles() {
        chromeDriver.findElement(By.xpath("//a[contains(@rev,'news|header')]")).click();
        new WebDriverWait(chromeDriver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        chromeDriver.findElement(By.xpath("//button[@data-bbc-title]")).click();

        WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(@class,'gs-c-promo-heading__title')]")));
        List<WebElement> secondaryTitlesElementsList = chromeDriver.findElements(By.xpath("//h3[contains(@class,'gs-c-promo-heading__title')]"));

        List<String> expectedSecondaryTitles = Arrays.asList(
                "Charlie Hebdo republishes Mohammed cartoons",
                "Zimbabwe to return farmland seized from foreigners",
                "Mauritius oil spill clean-up crew in fatal capsize",
                "Heart of Belgian mayor found entombed in fountain",
                "Melania Trump ex-confidante dishes on Ivanka feud",
                "Turkey detains 'top Islamic State commander'",
                "Hotel Rwanda hero 'abducted' in Dubai, says family",
                "Tony Abbott in talks over Brexit trade role",
                "Deepfake detection tool unveiled by Microsoft");

        List<String> secondaryTitlesText = new ArrayList<String>();
        for (int i = 2; i < 11; i++) {
            secondaryTitlesText.add(secondaryTitlesElementsList.get(i).getText());
        }
        int index = 0;
        for (String title: secondaryTitlesText) {
            assertEquals(title, expectedSecondaryTitles.get(index));
            index++;
        }
    }

    @Test
    public void checkSearchResultsAgainstNewsHeadlineArticleCategoryLink() {
        chromeDriver.findElement(By.xpath("//a[contains(@rev,'news|header')]")).click();
        new WebDriverWait(chromeDriver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        chromeDriver.findElement(By.xpath("//button[@data-bbc-title]")).click();

        WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(@class,'gs-c-promo-heading__title')]")));
        String newsHeadlineArticleCategoryLink = chromeDriver.findElement(By.xpath("//a[@aria-label]/span")).getText();

        chromeDriver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(newsHeadlineArticleCategoryLink, Keys.ENTER);
        List<WebElement> searchResultsMetadata = chromeDriver.findElements(By.xpath("//span[@type='category']"));
        String searchResultsFirsItemRegionMetadata = searchResultsMetadata.get(1).getText();
        String expectedFirsItemRegionMetadata = "US & Canada";

        assertEquals(searchResultsFirsItemRegionMetadata, expectedFirsItemRegionMetadata);
    }
}
