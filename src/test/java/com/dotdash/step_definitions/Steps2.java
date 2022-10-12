package com.dotdash.step_definitions;

import com.dotdash.pages.FirstPage;
import com.dotdash.pages.SecondPage;
import com.dotdash.pages.ThirdPage;
import com.dotdash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps2 {
    FirstPage firstPage = new FirstPage();
    SecondPage secondPage = new SecondPage();
    ThirdPage thirdPage = new ThirdPage();
    Wait<WebDriver> wait = new WebDriverWait(Driver.get(), 15);
    Actions actions = new Actions(Driver.get());

    @When("user get {string}")
    public void user_get(String startPage) {
        Driver.get().get(startPage);
    }

    @When("click on Get Started link")
    public void click_on_Get_Started_link() {
        actions.moveToElement(firstPage.closeCookieButton).click();
        actions.moveToElement(firstPage.getStarted).perform();
        firstPage.getStarted.click();
    }

    @When("write {string} in name")
    public void write_in_name(String name) {
        wait.until(ExpectedConditions.titleIs("Agent Dashboard"));
        wait.until(ExpectedConditions.elementToBeClickable(secondPage.clientNameInputBox));
        secondPage.clientNameInputBox.sendKeys("Lina");
    }

    @When("chose {string} in State")
    public void chose_in_State(String state) {
        wait.until(ExpectedConditions.elementToBeClickable(secondPage.stateChoice));
        secondPage.stateChoice.sendKeys(state + Keys.ENTER);


    }

    @When("chose {string} Primary Occupation")
    public void chose_primary_Occupation(String occupation) {
        wait.until(ExpectedConditions.elementToBeClickable(secondPage.primaryOccupation));
        secondPage.primaryOccupation.sendKeys(occupation + Keys.ENTER + Keys.TAB);
    }

    @When("click on Start Quote button")
    public void and_click_on_Start_Quote_button() {
        wait.until(ExpectedConditions.elementToBeClickable(secondPage.startButton));
        actions.moveToElement(secondPage.startButton);
        secondPage.startButton.click();
    }

    @Then("verify recommended Products page is loaded")
    public void verify_recommended_Products_page_is_loaded() {
        wait.until(ExpectedConditions.titleIs("BTIS"));
//        System.out.println("thirdPage.verifyState = " + thirdPage.verifyState.getAttribute("data-dtname"));
//        System.out.println("thirdPage.verifyBusiness = " + thirdPage.verifyBusiness.getAttribute("data-dtname"));
//        Assert.assertEquals(thirdPage.verifyState.getAttribute("data-dtname"), "Change State:Georgia");
//        Assert.assertEquals(thirdPage.verifyBusiness.getAttribute("data-dtname"), "Change Type of business:Accounting");
    }

}
