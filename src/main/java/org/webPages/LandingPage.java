package org.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.elm.sharedMethod.*;

public class LandingPage {
    WebDriver driver;



    public LandingPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[contains(.,'الخدمات')])[1]")
    private WebElement serviceButton;

    public void clickOnServicesButton()  {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mouseClickAction(serviceButton);
        serviceButton.click();
    }

}