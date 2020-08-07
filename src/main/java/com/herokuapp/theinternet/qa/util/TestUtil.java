package com.herokuapp.theinternet.qa.util;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class TestUtil extends TestBase
{
    public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long EXPLICIT_WAIT = 5;
    public static final long IMPLICIT_WAIT = 5;

    //-------------------------------------------------

    public static String getCurrentPageTitle() { return webDriver.getTitle(); }

    public static void clickOnPageLink(List<WebElement> _pageLinks, String _href)
    {
        for (WebElement _webElement : _pageLinks)
        {
            String _elementHref = _webElement.getAttribute("href");

            if (_elementHref.endsWith(_href))
            {
                _webElement.click();
                break;
            }
        }
    }


    public static WebElement getCurrentFrame()
    {
        WebElement _currentFrame = (WebElement) ((JavascriptExecutor) webDriver).executeScript("return window.frameElement");
        return _currentFrame;
    }

    public static boolean inFrameWithId(String _id)
    {
        WebElement _currentFrame = getCurrentFrame();
        String _currentFrameId = _currentFrame.getAttribute("id");

        return _currentFrameId.equals(_id);
    }

    public static void switchToFrame(WebElement _frame) { webDriver.switchTo().frame(_frame); }



    public static Alert switchToAlert()
    {
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        return  webDriver.switchTo().alert();
    }

    public static void acceptCurrentAlert(boolean _alertIsAccepted)
    {
        Alert _alert = switchToAlert();

        if(_alertIsAccepted)
            _alert.accept();
        else
            _alert.dismiss();
    }



    public static void switchToTab(String _expectedTitle)
    {
        String firstWindow = webDriver.getWindowHandle();

        Set<String> allWindows = webDriver.getWindowHandles();

        for (String windowHandle : allWindows)
        {
            if (!windowHandle.equals(firstWindow))
            {
                webDriver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(_expectedTitle))
                    break;
            }
        }
    }

    public static void pressKey(Keys _key) { interactWithCurrentPage.sendKeys(_key).perform(); }

    public static void hoverOverElement(WebElement _element) { interactWithCurrentPage.moveToElement(_element).perform(); }


}

