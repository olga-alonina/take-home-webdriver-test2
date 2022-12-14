package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_TabPages {
    public New_TabPages() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[href='/windows/new']")
    public WebElement clickHereLink;
    @FindBy(tagName = "h3")
    public WebElement textNewWindow;
}
