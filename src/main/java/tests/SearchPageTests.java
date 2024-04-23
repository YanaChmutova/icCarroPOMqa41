package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTests extends BaseTest{

    @Test
    public void TestTitleText() {
        Assert.assertEquals(searchPage.getTextMainTitle(),
                "Find your car now!");
    }
}