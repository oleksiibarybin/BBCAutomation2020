package com.bbc.ta.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NewsTitlesTest extends BaseTest {


    @BeforeMethod
    public void navigateToNews() {
        getMainHorizontalMenu()
                .clickOnNewsPageLink();
    }

    @Test
    public void checkNewsHeadlineArticleTitle() {
        assertEquals(
                getNewsPage().getTextNewsHeadLineTitle(),
                "England region faces restrictions as cases spike",
                "Text of news category headline title is NOT equal to expected");
    }

    @Test
    public void checkNewsSecondaryTitles() {
        List<String> expectedSecondaryTitles = Arrays.asList(
                "Greece moves migrants to new camp after fire",
                "Navalny's aides say poison found on water bottle",
                "Why fires in Siberia threaten us all",
                "Protesters topple conquistador statue in Colombia",
                "Police 'requested heat ray' for White House protest",
                "Biden warning for UK over post-Brexit trade deal");
        int index = 0;
        for (String title : getNewsPage().getTextForFirstSixSecondaryTitles()) {
            assertEquals(title, expectedSecondaryTitles.get(index), "Text of news category one of secondary titles is NOT equal to expected");
            index++;
        }
    }

    @Test
    public void checkSearchResultsAgainstNewsHeadlineArticleCategoryLink() {
        String expectedFirsItemRegionMetadata = "World";

        String searchResultsFirsItemRegionMetadata =
                getMainHorizontalMenu()
                        .findTextBySearch(getNewsPage().getTextNewsHeadLineLocationCategory())
                        .getTextSearchResultsCategory();

        assertEquals(
                searchResultsFirsItemRegionMetadata,
                expectedFirsItemRegionMetadata,
                "Text of headline article category first search result is NOT equal to expected");
    }
}
