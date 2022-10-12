package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Notification_MessagePage {
    public Notification_MessagePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="flash")
    public WebElement responseMessage;

    @FindBy(css = " [href='/notification_message']")
    public WebElement clickLink;
}
