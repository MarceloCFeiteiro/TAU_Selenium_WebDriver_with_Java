package javaScript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollfifthParagraph(){
        homePage.clickInfiniteScrooll().scrollToParagraph(5);
    }
}
