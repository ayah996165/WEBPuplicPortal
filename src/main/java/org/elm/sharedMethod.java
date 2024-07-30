package org.elm;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

import static org.elm.webBase.driver;

public class sharedMethod {


    public static void  waitUntilElementVisible(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(webBase.getDriver (),90);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementClickable(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(webBase.getDriver (),30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


    public static void mouseClickAction(WebElement Locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) webBase.getDriver ();
        js.executeScript("arguments[0].scrollIntoView()", Locator);
        js.executeScript("arguments[0].click()", Locator);
    }

    public static void jsScrollDown(WebElement Locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) webBase.getDriver ();
        js.executeScript("window.scrollBy(0,350)", Locator);
    }

    public static void waitElement(WebElement Locator)
    {
        WebDriverWait wait = new WebDriverWait(webBase.getDriver (),10);
        wait.until(ExpectedConditions.elementToBeClickable((Locator)));
    }

    public static void clickByJavaScript(WebElement element)
    {
        waitUntilElementVisible(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }


    public static void clickByAction(WebElement element)
    {

        Actions actions = new Actions(driver);

        actions.moveToElement(element).click().perform();

    }


    public static void MouseClickAction(WebElement Locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) webBase.getDriver ();
        js.executeScript("window.scrollBy(0,350)", Locator);

        js.executeScript("document.getElementByXpath('"+ Locator +"').click();");
    }

    public static void scrolToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) webBase.getDriver ();

        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static int generateRandomNumber()
    {

        Random rand = new Random();
        return  rand.nextInt((900 - 1) + 1) + 1;
    }


}
