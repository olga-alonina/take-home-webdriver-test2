package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    public DropDownPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#content #dropdown")
    public WebElement dropDown;

    public void click_on(String nameButton) {
        DropDownPage dropDownPage = new DropDownPage();
        Select select = new Select(dropDownPage.dropDown);
        switch (nameButton.toLowerCase()) {
            case "option 1":
                select.selectByVisibleText("Option 1");
                break;
            case "option 2":
                select.selectByVisibleText("Option 2");
                break;
        }
    }
}