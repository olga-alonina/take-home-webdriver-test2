package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPage {
    public SecondPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "hsx_ss_businesname_an")
   public WebElement clientNameInputBox;

    @FindBy(css = "[id='hsx_ss_state_an-selectized']")
    public WebElement stateChoice;
    @FindBy(css ="[id='hsx_ss_occupation_an-selectized']")
    public WebElement  primaryOccupation;

    @FindBy(id="hsx_ss_submitnewquote_btn")
    public WebElement startButton;

}
