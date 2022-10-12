package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {
    public ContextMenuPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "hot-spot")
    public WebElement square;
}
