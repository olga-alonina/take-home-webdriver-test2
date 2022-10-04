package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Mouse_HoverPage {
    public List<String> actualLinks;
    public List<String> actualNames;

    public Mouse_HoverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h5")
    public List<WebElement> names;

    @FindBy(css = "[class='figcaption'] a")
    public List<WebElement> profilesLinks;

    @FindBy(css = "[src='/img/avatar-blank.jpg']")
    public List<WebElement> amountPics;

    public void assertionLink() {
        actualLinks = new ArrayList<>();
        for (WebElement eachLink : profilesLinks) {
            if (eachLink.isDisplayed()) {
                actualLinks.add(eachLink.getText());
            }
            break;
        }
    }

    public void nameAssertion() {
        actualNames = new ArrayList<>();
        for (WebElement eachName : names) {
            if (eachName.isDisplayed()) {
                actualNames.add(eachName.getText());
            }
            break;
        }
    }
}

