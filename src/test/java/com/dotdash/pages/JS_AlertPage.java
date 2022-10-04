package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JS_AlertPage {

    public JS_AlertPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[onclick='jsAlert()']")
    public WebElement JSAlert;

    @FindBy(css = "[onclick='jsConfirm()']")
    public WebElement JSConfirm;

    @FindBy(css = "[onclick='jsPrompt()']")
    public WebElement JSPrompt;

    @FindBy(id = "result")
    public WebElement message;
    public String alertText;

    public void click_on(String nameButton) {
        switch (nameButton.toLowerCase()) {
            case "js alert":
                JSAlert.click();
                Alert alert = Driver.getDriver().switchTo().alert();
                alertText = alert.getText().toLowerCase();
                Driver.getDriver().switchTo().alert().accept();
                break;
            case "js confirm":
                JSConfirm.click();
                Alert alert1 = Driver.getDriver().switchTo().alert();
                alertText = alert1.getText().toLowerCase();
                Driver.getDriver().switchTo().alert().accept();
                break;
            case "js prompt":
                JSPrompt.click();
                Alert alert2 = Driver.getDriver().switchTo().alert();
                alertText = alert2.getText().toLowerCase();
                Driver.getDriver().switchTo().alert().sendKeys("Important message ");
                Driver.getDriver().switchTo().alert().accept();

                break;
        }
    }
}
