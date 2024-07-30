package org.webPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.elm.sharedMethod.waitUntilElementVisible;

@Getter
public class ServicesPage {
    WebDriver driver;



    public ServicesPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath  = "//h2[@class='fs-4 my-3 text-black'][contains(.,'التسجيل العيني الأول')]")
    private WebElement firstRigestrationService;

    public void clickOnFirstRegistrationService()  {
        waitUntilElementVisible(firstRigestrationService);
        firstRigestrationService.click();
    }

}
