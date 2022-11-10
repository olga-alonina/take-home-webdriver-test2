package com.dotdash.step_definitions;

import com.dotdash.pages.Mail.MailStartPage;
import com.dotdash.pages.Mail.SentPage;
import com.dotdash.pages.Mail.WriteLetterPage;
import com.dotdash.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailTest {
    MailStartPage mailStartPage = new MailStartPage();
    WriteLetterPage writeLetterPage = new WriteLetterPage();
    SentPage sentPage = new SentPage();
    Wait<WebDriver> wait = new WebDriverWait(Driver.get(), 25);
    Actions actions = new Actions(Driver.get());

    @Test()
    public void goInTest() throws InterruptedException {
        //set up
        Driver.get().get("https://mail.ru");
        Driver.get().manage().window().maximize();
        mailStartPage.comeInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(mailStartPage.signInIframe));
        Driver.get().switchTo().frame(mailStartPage.signInIframe);
        //inputs
        mailStartPage.emailInput.sendKeys("olga_alonina1804@mail.ru");
        mailStartPage.enterPasswordButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(mailStartPage.passwordInput));
        mailStartPage.passwordInput.sendKeys("wrhcpl123Q");
        mailStartPage.signInButton.click();
        //come in
        wait.until(ExpectedConditions.elementToBeClickable(sentPage.sentFolder));
        Assert.assertTrue(Driver.get().getTitle().contains("Входящие - Почта Mail.ru"));

        //for future assertion verification
        sentPage.sentFolder.click();
        sentPage.markAll.click();
        String numb = sentPage.numberOfLetter.getText();
        int beforeSize = Integer.parseInt(numb);
        System.out.println("beforeSize = " + beforeSize);

        //send letter
        writeLetterPage.writeLetterButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(writeLetterPage.whomField));
        writeLetterPage.whomField.sendKeys("olga.alonina@gmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(writeLetterPage.aboutField));
        writeLetterPage.aboutField.sendKeys("Practice Ola");

        wait.until(ExpectedConditions.elementToBeClickable(writeLetterPage.textField));
        writeLetterPage.textField.sendKeys("Random text to send");

        wait.until(ExpectedConditions.elementToBeClickable(writeLetterPage.sendIt));
        writeLetterPage.sendIt.click();

        //catch number of letter after sent
        //sentPage.markAll.click();
        Thread.sleep(25000);
        String numb1 = sentPage.numberOfLetter.getText();
        int afterSize = Integer.parseInt(numb1);
        System.out.println("afterSize = " + afterSize);
        Assert.assertEquals(beforeSize + 1, afterSize);//verify number of letters
        //from whom
        int y1Mark = 0;
        int y2Mark = 0;
        int y3Mark = 0;
        System.out.println("sentPage.verifyFromWho.size() = " + sentPage.verifyFromWho.size());
        System.out.println("sentPage.verifyFromWho.size() = " + sentPage.verifyAbout.size());
        System.out.println("sentPage.verifyFromWho.size() = " + sentPage.verifyTextField.size());

        for (WebElement each : sentPage.verifyFromWho) {
            if (each.getText().equalsIgnoreCase("olga.alonina@gmail.com")) {
                y1Mark = each.getLocation().getY();//verification about
                for (WebElement each1 : sentPage.verifyAbout) {
                    if (each1.getText().equalsIgnoreCase("Practice Ola")) {
                        y2Mark = each1.getLocation().getY();
                        if (y2Mark-y1Mark>=-5) {
                            //verification text
                            for (WebElement each2 : sentPage.verifyTextField) {
                                if (each2.getText().contains("Random text to send")) {
                                    y3Mark = each2.getLocation().getY();
                                    if (y3Mark-y2Mark>=-5) {
                                        System.out.println("Assertion pass");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}