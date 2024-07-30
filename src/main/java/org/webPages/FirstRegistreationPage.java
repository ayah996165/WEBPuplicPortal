package org.webPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.elm.sharedMethod.waitUntilElementVisible;

@Getter
public class FirstRegistreationPage {
    WebDriver driver;



    public FirstRegistreationPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath  = "(//span[contains(.,'بدء الخدمة')])[1]")
    private WebElement startServiceButton;

    public void clickOnStartServiceButton()  {
        waitUntilElementVisible(startServiceButton);
        startServiceButton.click();
    }

}
