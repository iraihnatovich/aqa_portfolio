package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.Input;
import wrappers.TextMessage;

public class LoginPage extends BasePage {
    private final By emailInputLocator = By.cssSelector("[data-testid='textbox-login']");
    private final By pswInputLocator = By.name("password");
    private final By logInButtonLocator = By.xpath("//div[text() = 'Log in']");
    private final By errorMessageLocator = By.xpath("//span[contains(text(), 'Either')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    public Input getEmailInput() {
        return new Input(driver, emailInputLocator);
    }

    public Input getPasswordInput() {
        return new Input(driver, pswInputLocator);
    }

    public Button getLoginButton() {
        return new Button(driver, logInButtonLocator);
    }

    public TextMessage getErrorMessage(){
        return new TextMessage(driver, errorMessageLocator);
    }

    public LoginPage enterEmail(String email) {
        getEmailInput().sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getPasswordInput().sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public DashboardPage successfulLogIn(User user) {
        enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        return new DashboardPage(driver);
    }
}
