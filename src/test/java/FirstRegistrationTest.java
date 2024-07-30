import org.elm.webBase;
import org.testng.Assert;
import org.webPages.*;
import org.testng.annotations.Test;

import java.awt.*;

import static org.elm.sharedMethod.*;


public class FirstRegistrationTest extends webBase {

    LoginPage loginPage;
    LandingPage landingPage;
    ServicesPage servicesPage;
    FirstRegistreationPage firstRegistreationPage;
    ManageRolePage manageRolePage;
    FirstRegistreationCreationPage firstRegistreationCreationPage;

    @Test(description = "To test the First Registration service")
    public void verifyFirstRegistration() throws InterruptedException, AWTException {

        loginPage = new LoginPage(getDriver ());
       landingPage=new LandingPage(getDriver());
       servicesPage=new ServicesPage(getDriver());
       firstRegistreationPage=new FirstRegistreationPage(getDriver());
        manageRolePage=new ManageRolePage(getDriver());
        firstRegistreationCreationPage=new FirstRegistreationCreationPage(getDriver());


       loginPage.login();
       manageRolePage.clickOnStartNow();
       landingPage.clickOnServicesButton();
       servicesPage.clickOnFirstRegistrationService();
       firstRegistreationPage.clickOnStartServiceButton();
       firstRegistreationCreationPage.enterDeedNumber();
       firstRegistreationCreationPage.enterDeedDate();
       clickByAction(firstRegistreationCreationPage.getContinueButton());
       Thread.sleep(10000);
       clickByJavaScript(firstRegistreationCreationPage.getContinueButton());
       firstRegistreationCreationPage.selectParcel();
       firstRegistreationCreationPage.chooseBuilding();
       clickByJavaScript(firstRegistreationCreationPage.getContinueButton());
       // clickByJavaScript(firstRegistreationCreationPage.getContainButton());
       // firstRegistreationCreationPage.clickOnContinueButton();
        MouseClickAction(firstRegistreationCreationPage.getContinueButton());

        firstRegistreationCreationPage.clickOcCheckBoxes();
        firstRegistreationCreationPage.clickOnSubmitButton();
        firstRegistreationCreationPage.sendOTP();

        Assert.assertTrue(firstRegistreationCreationPage.getSuccessMessage().isDisplayed());









    }

}
