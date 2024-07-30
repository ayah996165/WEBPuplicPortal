package org.elm;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.elm.readPropertiesFile.initalizePropertyFile;
import static org.elm.readPropertiesFile.properties;


public class webBase {

    @Getter
    protected static WebDriver driver ;


    public WebDriver doBrowserSetup()
    {
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        return driver;
    }

    @BeforeMethod
    public  void navigateToPublicPortalWebsite(){

        //get URL
        WebDriver driver = doBrowserSetup();
        initalizePropertyFile();
        driver.get(properties.getProperty("puplicPortalUrl"));
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}
