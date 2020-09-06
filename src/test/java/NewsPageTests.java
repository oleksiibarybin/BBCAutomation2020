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
    private WebDriver driver;
    private String BASE_URL = "https://www.bbc.com";
    private String CHROMEDRIVER_LOCAL_PATH = "src\\main\\resources\\chromedriver.exe";

    private String LINK_NEWS_CATEGORY = "//a[@rev='news|header']";
    private String INPUT_SEARCH = "//input[@id='orb-search-q']";
    private String BUTTON_SIGNIN_LATER_REGISTRATION_POPUP = "//button[@data-bbc-title]";

    private String TEXT_NEWS_HEADLINE_TITLE = "//h3[contains(@class,'gel-paragon-bold')]";
    private String TEXT_SECONDARY_TITLES = "//h3[contains(@class,'gel-pica-bold')]";
    private String TEXT_HEADLINE_NEWS_LOCATION_CATEGORY = "//a[@aria-label]/span";
    private String TEXT_SEARCH_RESULTS_NEWS_CATEGORY = "//span[@type='category']";


    private String LINK_CORONAVIRUS_CATEGORY = "//span[text()='Coronavirus']/ancestor::a";
    private String LINK_CORONAVIRUS_STORY_CATEGORY = "//span[text()='Your Coronavirus Stories']/ancestor::a";
    private String LINK_SHARE_CORONAVIRUS_STORY = "//h3[contains(text(),'How to share')]//ancestor::a";

    private String INPUT_TEXTAREA_CORONA_SHARE_STORY_FORM_YOUR_STORY = "//textarea[@aria-label='Tell us your story. ']";
    private String INPUT_CORONA_SHARE_STORY_FORM_NAME = "//input[@aria-label='Name']";
    private String CHECKBOXES_CORONA_SHARE_STORY_FORM = "//input[@type='checkbox']";
    private String BUTTON_CORONA_SHARE_STORY_FORM_SUBMIT = "//button[text()='Submit']";
    private String TEXT_CORONA_SHARE_STORY_FORM_ERROR = "//div[@class='input-error-message']";


    private String CORONA_SHARE_STORY_VALID_NAME = "Oleksii";
    private String CORONA_SHARE_STORY_VALID_STORY = "I have some coronavirus story to tell";
    private String CORONA_SHARE_STORY_FORM_YOUR_STORY_ERROR_TEXT = "can't be blank";
    private String CORONA_SHARE_STORY_FORM_NAME_ERROR_TEXT = "Name can't be blank";
    private String CORONA_SHARE_STORY_FORM_CHECKBOX_ERROR_TEXT = "must be accepted";


    public void clickOnElement(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        driver.findElement(By.xpath(locator)).click();
    }

    public void setInputValue(String locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }

    public void setCheckboxChecked(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        if (!element.isSelected())
            element.click();
    }

    public void setCoronavirusStoryFormCheckboxesChecked(String locator) {
        List<WebElement> checkboxesElementsList = driver.findElements(By.xpath(locator));
        WebElement checkboxIAmOverSixteen = checkboxesElementsList.get(1);
        WebElement checkboxIAcceptTerms = checkboxesElementsList.get(2);
        setCheckboxChecked(checkboxIAmOverSixteen);
        setCheckboxChecked(checkboxIAcceptTerms);
    }

    public void navigateToPage(String[] locators) {
        for (int i = 0; i < locators.length; i++)
            clickOnElement(locators[i]);
    }

    @BeforeTest
    public void suiteSetUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCAL_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        driver.findElement(By.xpath(LINK_NEWS_CATEGORY)).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath(BUTTON_SIGNIN_LATER_REGISTRATION_POPUP)).click();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath(LINK_NEWS_CATEGORY)).click();
    }

    @AfterTest
    public void suiteTearDown() {
        driver.close();
    }

    @Test(groups = {"news titles"})
    public void checkNewsHeadlineArticleTitle() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_NEWS_HEADLINE_TITLE)));
        String mainTitle = driver.findElement(By.xpath(TEXT_NEWS_HEADLINE_TITLE)).getText();
        assertEquals(
                mainTitle,
                "Trump panned over reports he mocked US military",
                "Text of news category headline title is NOT equal to expected");
    }

    @Test(groups = {"news titles"})
    public void checkNewsSecondaryTitles() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_SECONDARY_TITLES)));
        List<WebElement> secondaryTitlesElementsList = driver.findElements(By.xpath(TEXT_SECONDARY_TITLES));

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
            assertEquals(title, expectedSecondaryTitles.get(index), "Text of news category one of secondary titles is NOT equal to expected");
            index++;
        }
    }

    @Test(groups = {"search results"})
    public void checkSearchResultsAgainstNewsHeadlineArticleCategoryLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_NEWS_HEADLINE_TITLE)));
        String newsHeadlineArticleCategoryLink = driver.findElement(By.xpath(TEXT_HEADLINE_NEWS_LOCATION_CATEGORY)).getText();

        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(newsHeadlineArticleCategoryLink, Keys.ENTER);
        List<WebElement> searchResultsMetadata = driver.findElements(By.xpath(TEXT_SEARCH_RESULTS_NEWS_CATEGORY));
        String searchResultsFirsItemRegionMetadata = searchResultsMetadata.get(1).getText();
        String expectedFirsItemRegionMetadata = "US & Canada";

        assertEquals(
                searchResultsFirsItemRegionMetadata,
                expectedFirsItemRegionMetadata,
                "Text of headline article category first search result is NOT equal to expected");
    }

    @Test(groups = {"story submission"})
    public void checkCoronaVirusStorySubmissionFormResponseOnEmptyStoryTextArea() {
        navigateToPage(new String[]{LINK_CORONAVIRUS_CATEGORY, LINK_CORONAVIRUS_STORY_CATEGORY, LINK_SHARE_CORONAVIRUS_STORY});

        setInputValue(INPUT_TEXTAREA_CORONA_SHARE_STORY_FORM_YOUR_STORY, "");
        setInputValue(INPUT_CORONA_SHARE_STORY_FORM_NAME, CORONA_SHARE_STORY_VALID_NAME);

        setCoronavirusStoryFormCheckboxesChecked(CHECKBOXES_CORONA_SHARE_STORY_FORM);

        clickOnElement(BUTTON_CORONA_SHARE_STORY_FORM_SUBMIT);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)));
        assertEquals(
                driver.findElement(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)).getText(),
                CORONA_SHARE_STORY_FORM_YOUR_STORY_ERROR_TEXT,
                "Text of my coronavirus story form textarea error message is NOT equal to expected");
    }

    @Test(groups = {"story submission"})
    public void checkCoronaVirusStorySubmissionFormResponseOnEmptyNameInput() {
        navigateToPage(new String[]{LINK_CORONAVIRUS_CATEGORY, LINK_CORONAVIRUS_STORY_CATEGORY, LINK_SHARE_CORONAVIRUS_STORY});

        setInputValue(INPUT_TEXTAREA_CORONA_SHARE_STORY_FORM_YOUR_STORY, CORONA_SHARE_STORY_VALID_STORY);
        setInputValue(INPUT_CORONA_SHARE_STORY_FORM_NAME, "");

        setCoronavirusStoryFormCheckboxesChecked(CHECKBOXES_CORONA_SHARE_STORY_FORM);

        clickOnElement(BUTTON_CORONA_SHARE_STORY_FORM_SUBMIT);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)));
        assertEquals(
                driver.findElement(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)).getText(),
                CORONA_SHARE_STORY_FORM_NAME_ERROR_TEXT,
                "Text of my coronavirus story form name input error message is NOT equal to expected");
    }

    @Test(groups = {"story submission"})
    public void checkCoronaVirusStorySubmissionFormResponseOnUncheckedIAmOverSixteenCheckbox() {
        navigateToPage(new String[]{LINK_CORONAVIRUS_CATEGORY, LINK_CORONAVIRUS_STORY_CATEGORY, LINK_SHARE_CORONAVIRUS_STORY});

        setInputValue(INPUT_TEXTAREA_CORONA_SHARE_STORY_FORM_YOUR_STORY, CORONA_SHARE_STORY_VALID_STORY);
        setInputValue(INPUT_CORONA_SHARE_STORY_FORM_NAME, CORONA_SHARE_STORY_VALID_NAME);

        List<WebElement> checkboxesElementsList = driver.findElements(By.xpath(CHECKBOXES_CORONA_SHARE_STORY_FORM));
        WebElement checkboxIAcceptTerms = checkboxesElementsList.get(2);
        setCheckboxChecked(checkboxIAcceptTerms);

        clickOnElement(BUTTON_CORONA_SHARE_STORY_FORM_SUBMIT);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)));
        assertEquals(
                driver.findElement(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)).getText(),
                CORONA_SHARE_STORY_FORM_CHECKBOX_ERROR_TEXT,
                "Text of my coronavirus story form required checkboxes error message is NOT equal to expected");
    }

    @Test(groups = {"story submission"})
    public void checkCoronaVirusStorySubmissionFormResponseOnUncheckedIAcceptTermsCheckbox() {
        navigateToPage(new String[]{LINK_CORONAVIRUS_CATEGORY, LINK_CORONAVIRUS_STORY_CATEGORY, LINK_SHARE_CORONAVIRUS_STORY});

        setInputValue(INPUT_TEXTAREA_CORONA_SHARE_STORY_FORM_YOUR_STORY, CORONA_SHARE_STORY_VALID_STORY);
        setInputValue(INPUT_CORONA_SHARE_STORY_FORM_NAME, CORONA_SHARE_STORY_VALID_NAME);

        List<WebElement> checkboxesElementsList = driver.findElements(By.xpath(CHECKBOXES_CORONA_SHARE_STORY_FORM));
        WebElement checkboxIAmOverSixteen = checkboxesElementsList.get(1);
        setCheckboxChecked(checkboxIAmOverSixteen);

        clickOnElement(BUTTON_CORONA_SHARE_STORY_FORM_SUBMIT);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)));
        assertEquals(
                driver.findElement(By.xpath(TEXT_CORONA_SHARE_STORY_FORM_ERROR)).getText(),
                CORONA_SHARE_STORY_FORM_CHECKBOX_ERROR_TEXT,
                "Text of my coronavirus story form required checkboxes error message is NOT equal to expected");
    }

}
