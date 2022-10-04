package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class JSErrorPage {
    public JSErrorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
