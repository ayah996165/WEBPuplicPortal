package org.webPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static org.elm.readPropertiesFile.properties;
import static org.elm.sharedMethod.*;

@Getter
public class FirstRegistreationCreationPage {
    WebDriver driver;



    public FirstRegistreationCreationPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath  = "//input[contains(@formcontrolname,'deedNumber')]")
    private WebElement deedNumber;

    @FindBy(xpath  = "//input[contains(@placeholder,'yyyy-mm-dd')]")
    private WebElement deedDate;

    @FindBy(xpath = "//select[contains(@aria-label,'Select month')]")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[contains(@aria-label,'Select year')]")
    private WebElement selectYear;

    @FindBy(xpath = "(//div[@class='btn-light ng-star-inserted'][contains(.,'7')])[1]")
    private WebElement day;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-next ng-star-inserted'][contains(.,'متابعة')]")
    private WebElement continueButton;

    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted'][contains(.,'اسم المنطقة')]")
    private WebElement regionName;

    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted'][contains(.,'اسم المحافظة')]")
    private WebElement governorateName;

    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted'][contains(.,'اسم الحي')]")
    private WebElement districtName;

    @FindBy(xpath = "//input[contains(@formcontrolname,'blockNumber')]")
    private WebElement planNumber;

    @FindBy(xpath = "//input[contains(@formcontrolname,'parcelNumber')]")
    private WebElement parcelNumber;

    @FindBy(xpath = "//label[@for='Documents'][contains(.,'نوع المبنى')]")
    private WebElement buildingTypeLabel;

    @FindBy(xpath = "//select[contains(@formcontrolname,'buildingType')]")
    private WebElement buildingType;

    @FindBy(xpath = "//label[@for='Documents'][contains(.,'عدد الادوار')]")
    private WebElement floorsNumber;

    @FindBy(xpath = "//input[contains(@autocomplete,'off')]")
    private WebElement inputText;

    @FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'منطقة الرياض')]")
    private WebElement ryad;


    @FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'امارة منطقة الرياض')]")
    private WebElement emara;

    @FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'الفلاح')]")
    private WebElement flah;

    @FindBy(xpath = "//button[@class='btn btn-primary mt-4 w-sm-100'][contains(.,'بحث')]")
    private WebElement search;

    @FindBy(xpath = "//div[@role='alertdialog'][contains(.,'لا توجد نتائج بحث')]")
    private WebElement noResult;

    @FindBy(xpath = "(//div[contains(@class,'p-checkbox-box')])[1]")
    private WebElement termsCheckBox;

    @FindBy(xpath = "(//div[contains(@class,'p-checkbox-box')])[2]")
    private WebElement secondCheckBox;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-next'][contains(.,'تقديم الطلب')]")
    private WebElement submitButton;

    @FindBy(xpath = "//input[contains(@id,'first')]")
    private WebElement one;

    @FindBy(xpath = "//input[contains(@id,'second')]")
    private WebElement two;

    @FindBy(xpath = "//input[contains(@id,'third')]")
    private WebElement three;

    @FindBy(xpath = "//input[contains(@id,'fourth')]")
    private WebElement four;

    @FindBy(xpath = "//button[@type='button'][contains(.,'التحقق')]")
    private WebElement validateOTP;

    @FindBy(xpath = "//h2[@class='section-title mb-2'][contains(.,'تم انشاء طلبك بنجاح')]")
    private WebElement successMessage;





    public void enterDeedNumber()  {
        waitUntilElementVisible(deedNumber);
        deedNumber.sendKeys(properties.getProperty("deedNumber"));
    }

    public void enterDeedDate()  {
        waitUntilElementVisible(deedDate);
        deedDate.click();
        setSelectYear();
        setSelectMonth();
        day.click();
    }

    public void setSelectMonth()  {
        waitUntilElementVisible(selectMonth);
        selectMonth.click();
        selectByText(selectMonth,"محرم");

    }

    public void setSelectYear()  {
        waitUntilElementVisible(selectYear);
        selectYear.click();
        selectByText(selectYear,"1440");

    }

    public void selectByText(WebElement dropDown,String text){
        Select objSelect=new Select(dropDown);
        objSelect.selectByVisibleText(text);

    }
    public void clickOnContinueButton()  {
        waitUntilElementVisible(continueButton);
        continueButton.click();
    }

    public void selectParcel()
    {

        waitUntilElementVisible(regionName);
        regionName.click();
        waitUntilElementVisible(inputText);
        inputText.sendKeys("منطقة الرياض");
        waitUntilElementVisible(ryad);
        ryad.click();


        waitUntilElementVisible(governorateName);
        governorateName.click();
        waitUntilElementVisible(inputText);
        inputText.sendKeys("امارة منطقة الرياض");
        waitUntilElementVisible(emara);
        emara.click();


        waitUntilElementVisible(districtName);
        districtName.click();
        waitUntilElementVisible(inputText);
        inputText.sendKeys("الفلاح");
        waitUntilElementVisible(flah);
        flah.click();



        waitUntilElementVisible(planNumber);
        planNumber.sendKeys("2924");

        waitUntilElementVisible(parcelNumber);
       // parcelNumber.sendKeys(String.valueOf(generateRandomNumber()));
        parcelNumber.sendKeys(properties.getProperty("parcelNumber"));


        waitUntilElementVisible(search);
        search.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        while (noResult.isDisplayed())
//        {
//            parcelNumber.clear();
//            parcelNumber.sendKeys(String.valueOf(generateRandomNumber()));
//            search.click();
//
//        }

    }

public void chooseBuilding()
{

    waitUntilElementVisible(buildingTypeLabel);
    scrolToElement(buildingTypeLabel);
    clickByJavaScript(buildingTypeLabel);
    selectByText(buildingType,"شقة");


}

public void clickOcCheckBoxes()
{
    clickByJavaScript(termsCheckBox);
    clickByJavaScript(secondCheckBox);}

    public void clickOnSubmitButton()
    {
     clickByJavaScript(submitButton);
    }

    public void sendOTP()
    {
        waitUntilElementVisible(one);
       one.sendKeys("1");
        two.sendKeys("2");
        three.sendKeys("3");
        four.sendKeys("4");
        validateOTP.click();
        waitUntilElementVisible(successMessage);

    }

}
