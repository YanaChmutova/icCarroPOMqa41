
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTests extends BaseTest{

    @Test
    public void TestTitleText() {
        Assert.assertEquals(searchPage.getTextMainTitle(),
                "Find your car now!");
    }

    @Test
    public void searchPositive() {
//        searchPage.fillLocation("Tel Aviv");
//        searchPage.fillDateFrom("03/05/2024");
//        searchPage.fillDateTo("05/05/2024");
//        searchPage.clickYallaBtn();
//        Assert.assertTrue(searchResultPage.verifyCarsDiplays());
    }
}
