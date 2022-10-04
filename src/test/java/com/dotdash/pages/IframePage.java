package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="mce_0_ifr")
    public WebElement iframe;

    @FindBy(tagName = "p")
    public WebElement textInIframe;


}
