package com.dotdash.pages.Mail;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MailStartPage {

    public MailStartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[data-click-counter='84226411']")
    public WebElement comeInButton;
    @FindBy(css = "[class='ag-popup__frame__layout__iframe']")
    public WebElement signInIframe;
    @FindBy(css = "[name='username']")
    public WebElement emailInput;
    //olga_alonina1804@mail.ru
    @FindBy(css = "[data-test-id='next-button']")
    public WebElement enterPasswordButton;
    //wrhcpl123Q
    @FindBy(css = "[name='password']")
    public WebElement passwordInput;
    @FindBy(css = "[data-test-id='submit-button']")
    public WebElement signInButton;
    @FindBy(css = "[class='_3dhsSkEldBsCDan3SUOiK8']>[class='base-0-2-1']")
    public WebElement closeAddResMailButton;







}
