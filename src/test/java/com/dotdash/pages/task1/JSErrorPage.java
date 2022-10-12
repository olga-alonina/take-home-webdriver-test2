package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class JSErrorPage {
    public JSErrorPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
