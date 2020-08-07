package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;

import com.herokuapp.theinternet.qa.util.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertsPage extends TestBase
{
    @FindBy(xpath="//button[text()='Click for JS Alert']")
    WebElement _jsAlertSimpleBtn;

    @FindBy(xpath="//button[text()='Click for JS Confirm']")
    WebElement _jsAlertConfirmBtn;

    @FindBy(xpath="//button[text()='Click for JS Prompt']")
    WebElement _jsAlertPromptBtn;

    @FindBy(id="result")
    WebElement _alertResults;

    public JSAlertsPage() { PageFactory.initElements(webDriver,this); }

    public void clickOnSimpleJSAlert() { _jsAlertSimpleBtn.click(); }

    public void clickOnJSConfirmAlert() { _jsAlertConfirmBtn.click(); }

    public void clickOnJSPromptAlert() { _jsAlertPromptBtn.click(); }

    public void typeIntoAlertPromptMsg(String _text)
    {
        System.out.println("Switching to Alert, typing something and pressing OK");
        Alert _alert = TestUtil.switchToAlert();
        _alert.sendKeys(_text);
    }

    public String getAlertResultText() { return _alertResults.getText(); }

}
