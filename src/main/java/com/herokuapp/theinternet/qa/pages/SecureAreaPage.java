package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends TestBase
{
    @FindBy(xpath="//div[@class='flash success']")
    WebElement _successfulLoginAlert;

    @FindBy(xpath="//i[contains(@class,'icon-signout')]")
    WebElement _logoutButton;

    //-------------------------------------------------------------------------
    public SecureAreaPage() { PageFactory.initElements(webDriver,this); }

    //-------------------------------------------------------------------------
    public String getLoginAlertMessage() { return _successfulLoginAlert.getText(); }

    public FormAuthPage pressLogoutButton()
    {
        _logoutButton.click();
        return new FormAuthPage();
    }
}
