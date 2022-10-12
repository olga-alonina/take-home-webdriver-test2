package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicLoadingPage {
    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(css = "#finish h4")
    public WebElement textLoad;
}
