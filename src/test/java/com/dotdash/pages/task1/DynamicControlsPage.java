package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
    public DynamicControlsPage() {
        PageFactory.initElements(Driver.get(), this);

    }


    @FindBy(css = "[onclick='swapCheckbox()']")
    public WebElement removeButton;

    @FindBy(id = "message")
    public WebElement text1;

    @FindBy(css = "[src='/img/ajax-loader.gif']")
    public WebElement loadLine;

    @FindBy(css = "[onclick='swapInput()']")
    public WebElement enableButton;
    public  void click_on(String nameButton) {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        switch (nameButton.toLowerCase()) {
            case "remove":
            case"add":
                dynamicControlsPage.removeButton.click();
                break;
            case "enable":
            case "disable":
                dynamicControlsPage.enableButton.click();
                break;
        }
    }


}
