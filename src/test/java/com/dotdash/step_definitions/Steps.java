package com.dotdash.step_definitions;

import com.dotdash.pages.task1.*;
import com.dotdash.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static com.dotdash.utilities.methods.dragAndDropJS;


public class Steps extends Hooks {
    LoginPage loginPage = new LoginPage();
    CheckboxPage checkboxPage = new CheckboxPage();
    ContextMenuPage contextMenuPage = new ContextMenuPage();
    Drag_DropPage drag_dropPage = new Drag_DropPage();
    Actions actions = new Actions(Driver.get());
    DropDownPage dropDownPage = new DropDownPage();
    DynamicContentPage dynamicContentPage = new DynamicContentPage();
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    FileDownloadPage fileDownloadPage = new FileDownloadPage();
    File_UploadPage file_uploadPage = new File_UploadPage();
    Floating_MenuPage floating_menuPage = new Floating_MenuPage();
    IframePage iframePage = new IframePage();
    Mouse_HoverPage mouse_hoverPage = new Mouse_HoverPage();
    JS_AlertPage js_alertPage = new JS_AlertPage();
    New_TabPages new_tabPages = new New_TabPages();
    Notification_MessagePage notification_messagePage = new Notification_MessagePage();
    WebDriverWait wait;
    String expected1;
    String expected2;
    String text1;
    String text2;
    String text3;
    String keep;
    int before_files;
    String textIframe;
    Set<String> actResults;


    @Given("user on {string} page")
    public void user_on_page(String pageName) {
        setup(pageName);
    }

    @When("user input {string} and {string}")
    public void user_input_and(String log, String pass) {
        loginPage.login(log, pass);
    }


    @Then("user should able to see {string}")
    public void user_should_able_to_see(String message) {
        Assert.assertTrue(loginPage.errorMessage.getText().contains(message));

    }

    @Then("status of box was changed")
    public void status_of_box_was_changed() {
        for (WebElement each_box : checkboxPage.checkBoxes) {
            //before click
            boolean act_status = each_box.isSelected();
            each_box.click();
            //after click
            boolean new_status = each_box.isSelected();
            Assert.assertEquals(!act_status, new_status);
        }
    }

    @When("user click on box")
    public void user_click_on_box() {
        actions.contextClick(contextMenuPage.square).perform();
    }

    @Then("user should be able to see alert menu")
    public void user_should_be_able_to_see_alert_menu() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals("You selected a context menu", alert.getText());
        alert.accept();

    }

    @When("user drags A to B")
    public void user_drags_A_to_B() throws InterruptedException {
        expected1 = drag_dropPage.text1.getText();
        expected2 = drag_dropPage.text2.getText();
        dragAndDropJS(drag_dropPage.element1, drag_dropPage.element2);

    }

    @Then("user should be able to see switching texts")
    public void user_should_be_able_to_see_switching_texts() {
        Assert.assertEquals(drag_dropPage.text1.getText(), expected2);
        Assert.assertEquals(drag_dropPage.text2.getText(), expected1);
    }

    @When("user click on {string}")
    public void user_click_on(String nameOption) {
        dropDownPage.click_on(nameOption);
    }

    @When("user click on button {string}")
    public void user_click_on_button(String nameOption) {
        keep = nameOption;
        dynamicControlsPage.click_on(nameOption);
    }

    @When("user click on checkboxes")
    public void user_click_on_checkboxes() {
        for (WebElement eachBox : checkboxPage.checkBoxes) {
            eachBox.click();
        }
    }

    @Then("user should be able to see that {string} was selected")
    public void user_should_be_able_to_see_that_was_selected(String nameOption) {
        Select select = new Select(dropDownPage.dropDown);
        Assert.assertEquals(nameOption, select.getFirstSelectedOption().getText());
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        text1 = dynamicContentPage.firstElement.getText();
        Driver.get().navigate().refresh();
        text2 = dynamicContentPage.firstElement.getText();
        Driver.get().navigate().refresh();
        text3 = dynamicContentPage.firstElement.getText();
    }

    @Then("content should be changed")
    public void content_should_be_changed() {
        Assert.assertNotEquals(text1, text2);
        Assert.assertNotEquals(text1, text3);
        Assert.assertNotEquals(text2, text3);
    }

    @And("uses explicit wait")
    public void uses_explicit_wait() {
        wait = new WebDriverWait(Driver.get(), 75);


    }

    @Then("verify that the checkbox {string}")
    public void verify_that_the_checkbox(String status) {
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadLine));
       wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.text1));
        if (!dynamicControlsPage.text1.getText().equals(status)) {
            dynamicControlsPage.click_on(keep);
            wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadLine));
        }
        Assert.assertEquals(dynamicControlsPage.text1.getText(), status);

    }

    @When("user click on button start")
    public void user_click_on_button_start() {
        dynamicLoadingPage.startButton.click();
    }

    @Then("asserts that {string} is displayed")
    public void asserts_that_is_displayed(String phrase) {
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadingPage.loadLine));
        Assert.assertEquals(dynamicLoadingPage.textLoad.getText(), phrase);
    }

    @When("clicks on the file")
    public void clicks_on_the_file() {
        before_files = methods.countFilesInFolder();
        fileDownloadPage.downloadLink.click();
    }

    @Then("asserts that the file is downloaded")
    public void asserts_that_the_file_is_downloaded() {
        int after_files = methods.countFilesInFolder();
        Assert.assertEquals(before_files + 1, after_files);
    }

    @When("clicks on {string}")
    public void clicks_on(String buttonName) {
        System.out.println("=>" + Driver.get().getCurrentUrl());
        file_uploadPage.click_on(buttonName);

    }

    @Then("asserts that {string}")
    public void asserts_that(String message) {
        Assert.assertEquals(file_uploadPage.responseMessage.getText(), message);
    }

    @When("user scrolls the page")
    public void user_scrolls_the_page() {
        actions.moveToElement(floating_menuPage.linkInBottom);
    }

    @Then("asserts that the floating menu is still displayed")
    public void asserts_that_the_floating_menu_is_still_displayed() {
        Assert.assertTrue(floating_menuPage.floatingMenu.isDisplayed());
    }

    @When("user type text inside iframe {string}")
    public void user_type_text_inside_iframe(String text) {
        Driver.get().switchTo().frame(iframePage.iframe);
        iframePage.textInIframe.clear();
        textIframe = text;
        iframePage.textInIframe.sendKeys(textIframe);
    }

    @Then("asserts that  text appeared as expected.")
    public void asserts_that_text_appeared_as_expected() {
        Assert.assertEquals(textIframe, iframePage.textInIframe.getText());
    }

    @When("user hover over on each image")
    public void user_hover_over_on_each_image() {
        for (WebElement each : mouse_hoverPage.amountPics) {
            actions.moveToElement(each).perform();
            mouse_hoverPage.nameAssertion();
            mouse_hoverPage.assertionLink();
        }
    }


    @Then("asserts that information is displayed for each image")
    public void asserts_that_information_is_displayed_for_each_image() {
        for (String each : mouse_hoverPage.actualNames) {
            Assert.assertTrue(each.contains("name: user"));
        }
        for (String each : mouse_hoverPage.actualLinks) {
            Assert.assertEquals(each, "View profile");
        }
        Assert.assertEquals(mouse_hoverPage.amountPics.size(), mouse_hoverPage.names.size(), mouse_hoverPage.profilesLinks.size());

    }

    @When("user click on button JS {string}")
    public void user_click_on_button_js(String JSButton) {
        js_alertPage.click_on(JSButton);

    }

    @Then("asserts alert {string}")
    public void asserts_alert(String message) {
        Assert.assertTrue(js_alertPage.alertText.contains(message.toLowerCase()));
    }

    @Then("result text will be {string}")
    public void result_text_will_be(String resultJS) {
        Assert.assertEquals(js_alertPage.message.getText().toLowerCase(), resultJS.toLowerCase());
    }

    @Then("asserts that the page contains error: {string}")
    public void asserts_that_the_page_contains_error(String expectedErrorMsg) {
        Assert.assertTrue(methods.JSLogsInfoTest(expectedErrorMsg));
    }

    @When("user clicks on the Click Here link")
    public void user_clicks_on_the_click_here_link() {
        new_tabPages.clickHereLink.click();

    }

    @Then("asserts that a new tab is opened with text {string}")
    public void asserts_that_a_new_tab_is_opened_with_text_new_window(String text) {
        String currentTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();
        for (String eachTab : allTabs) {
            if (!eachTab.equalsIgnoreCase(currentTab)) {
                Driver.get().switchTo().window(eachTab);
            }
        }
        Assert.assertEquals(new_tabPages.textNewWindow.getText(), text);
    }

    @When("user clicks on the Click Here link a multiple times")
    public void user_clicks_on_the_click_here_link_a_multiple_times() {
        actResults = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            notification_messagePage.clickLink.click();
            actResults.add(notification_messagePage.responseMessage.getText());
        }
    }

    @Then("asserts that one of the {string}")
    public void asserts_that_one_of_the(String respMess) {
        Set<String> expResults = new HashSet<>();
        expResults.add(respMess);
        if (expResults.size() == 3) {
            Assert.assertEquals(actResults, expResults);
            System.out.println("expResults = " + expResults);
            System.out.println("actResults = " + actResults);
        }
    }
}

