package com.dotdash.pages.Mail;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteLetterPage {
    public WriteLetterPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[class='compose-button__wrapper']")
    public WebElement writeLetterButton;
    @FindBy(css = "[tabindex='100']")
    public WebElement whomField;
    @FindBy(css = "[tabindex='400']")
    public WebElement aboutField;

    @FindBy(css = "[tabindex='505']")
    public WebElement textField;

    @FindBy(css = "[data-test-id='send']")
    public WebElement sendIt;
}

