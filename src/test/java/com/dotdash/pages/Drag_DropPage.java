package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Drag_DropPage {
    public Drag_DropPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "column-a")
    public WebElement element1;

    @FindBy(id = "column-b")
    public WebElement element2;

    @FindBy(css = "#column-a header")
    public WebElement text1;

    @FindBy(css = "#column-b header")
    public WebElement text2;
}