package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "[class='fa fa-2x fa-sign-in']")
    public WebElement loginBtn;

    @FindBy(id = "flash")
    public WebElement errorMessage;


    public void login(String log, String pass) {
        username.sendKeys(log);
        password.sendKeys(pass);
        loginBtn.click();
    }


}
