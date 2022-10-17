package com.dotdash.pages.Lina;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPage {
    public ThirdPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[data-dtname='Change State:Georgia']")
    public WebElement verifyState;

    @FindBy(css = "[data-dtname='Change Type of business:Accounting']")
    public WebElement verifyBusiness;
}
