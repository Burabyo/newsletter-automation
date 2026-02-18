package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.NewsletterPage;

public class NewsletterTests extends BaseTest {

    @Test
    public void testValidEmailSubmission() {
        NewsletterPage page = new NewsletterPage(driver);

        page.enterEmail("test@example.com");
        page.clickSubmit();

        Assertions.assertTrue(page.isModalDisplayed());
        Assertions.assertEquals("test@example.com", page.getConfirmedEmail());
    }

    @Test
    public void testInvalidEmailShowsError() {
        NewsletterPage page = new NewsletterPage(driver);

        page.enterEmail("invalidEmail");
        page.clickSubmit();

        Assertions.assertEquals("Valid email required", page.getErrorMessage());
    }

    @Test
    public void testEmptyEmailShowsError() {
        NewsletterPage page = new NewsletterPage(driver);

        page.enterEmail("");
        page.clickSubmit();

        Assertions.assertEquals("Valid email required", page.getErrorMessage());
    }
}

