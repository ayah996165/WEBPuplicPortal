package org.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.elm.sharedMethod.waitUntilElementVisible;

public class ManageRolePage {
    WebDriver driver;



    public ManageRolePage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary px-4 px-lg-5 w-100'][contains(.,'ابدأ الآن')]")
    private WebElement startNow;


    @FindBy(xpath  = "//span[@class='in-role-name ng-star-inserted'][contains(.,'فرد')]")
    private WebElement individual;

    public void chooseIndividualRole()  {
        waitUntilElementVisible(individual);
        individual.click();
    }

    public void clickOnStartNow()
    {
        waitUntilElementVisible(startNow);
        startNow.click();
    }


}
