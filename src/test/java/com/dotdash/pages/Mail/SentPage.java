package com.dotdash.pages.Mail;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class SentPage {

    public SentPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = "[href='/sent/']")
    public WebElement sentFolder;
    @FindBy(css = "[data-title-shortcut='Ctrl+A']")
    public WebElement markAll;
    @FindBy(xpath = "//td/span[1]//span/div")
    public WebElement numberOfLetter;
    @FindBy(css = "[role='rowgroup']>a")
    public List<WebElement> sentLetters;
    @FindBy(css = "[class='ll-crpt']")
    public List<WebElement> verifyFromWho;
    @FindBy(css = "[class='ll-sj__normal']")
    public List<WebElement> verifyAbout;
    @FindBy(css = "[class='ll-sp__normal']")
    public List<WebElement> verifyTextField;



}
