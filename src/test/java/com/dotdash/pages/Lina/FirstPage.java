package com.dotdash.pages.Lina;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
    public FirstPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id='hsx_ss_dpl_guest_link']")
    public WebElement getStarted;
    @FindBy(css = "[class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
    public WebElement closeCookieButton;


}
