package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KeyPressesPage extends TestBase
{
    @FindBy(xpath="//p[@id='result']")
    WebElement _pressedKeyInfo;

    public KeyPressesPage() { PageFactory.initElements(webDriver,this); }

    public String getPressedKeyInfo()
    {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='result']")));
        return _pressedKeyInfo.getText();
    }
}
