package com.dotdash.pages.task1;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class File_UploadPage {
    public File_UploadPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "file-submit")
    public WebElement uploadButton;
    @FindBy(tagName = "h3")
    public WebElement responseMessage;
    @FindBy(id = "file-upload")
    public WebElement chooseFileButton;

    public void click_on(String nameButton) {
        File_UploadPage file_uploadPage = new File_UploadPage();
        switch (nameButton.toLowerCase()) {
            case "choose file":
                chooseFileButton.sendKeys("//Users/olga/Desktop/Soap.png");
            case " upload button":
                uploadButton.click();
        }
    }
}
