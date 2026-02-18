package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {

    WebDriver driver;

    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(className = "submit-btn")
    WebElement submitButton;

    @FindBy(className = "error-message")
    WebElement errorMessage;

    @FindBy(id = "modal")
    WebElement successModal;

    @FindBy(id = "confirm-email")
    WebElement confirmEmail;

    @FindBy(id = "dismiss-btn")
    WebElement dismissButton;

    // Actions

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isModalDisplayed() {
        return successModal.isDisplayed();
    }

    public String getConfirmedEmail() {
        return confirmEmail.getText();
    }

    public void dismissModal() {
        dismissButton.click();
    }
}
