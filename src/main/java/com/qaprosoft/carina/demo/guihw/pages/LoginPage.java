package com.qaprosoft.carina.demo.guihw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.guihw.pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user-name")
    private ExtendedWebElement username;
    @FindBy(id = "password")
    private ExtendedWebElement password;
    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage logIn(String username, String password) {
        this.username.type(username);
        this.password.type(password);
        this.loginButton.click();
        return new InventoryPage(driver);

    }
}