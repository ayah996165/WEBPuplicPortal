package org.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;


import static org.elm.readPropertiesFile.properties;
import static org.elm.sharedMethod.waitUntilElementVisible;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath  = "(//span[contains(.,'تسجيل الدخول')])[4]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    private WebElement nationalIdOrIqamaInput;
    ;


    public void login() throws InterruptedException, AWTException {
        waitUntilElementVisible(loginButton);
        nationalIdOrIqamaInput.sendKeys(properties.getProperty("nationalIdOrIqamaInput"));
        loginButton.click();
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(10000);
        driver.navigate().refresh();

    }

}
