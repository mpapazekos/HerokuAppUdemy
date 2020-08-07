package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormAuthPage extends TestBase
{
    @FindBy(xpath="//i")
    WebElement _submitButton;

    @FindBy(xpath = "//h2[text() = 'Login Page']")
    WebElement _mainHeader;

    @FindBy(xpath="//input[@id='username']")
    WebElement _usernameField;

    @FindBy(xpath="//input[@id='password']")
    WebElement _passwordField;

    @FindBy(xpath="//div[@class='flash success']")
    WebElement _successfulLogoutAlert;

    @FindBy(xpath="//div[@class='flash error']")
    WebElement _failedLoginAlert;

    //-------------------------------------------------------------------------
    public FormAuthPage()
    {
      super();
      PageFactory.initElements(webDriver,this);
    }

    //-------------------------------------------------------------------------
    public String getSubmitButtonText() { return _submitButton.getText(); }

    public String getMainHeader() { return _mainHeader.getText(); }


    public SecureAreaPage customFormFillAndLogin(String _username, String _password)
    {
        _usernameField.sendKeys(_username);
        _passwordField.sendKeys(_password);
        _submitButton.click();

        return new SecureAreaPage();
    }

    public SecureAreaPage correctFormFillAndLogin()
    {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        _usernameField.sendKeys(username);
        _passwordField.sendKeys(password);
        _submitButton.click();

        return new SecureAreaPage();
    }

    public String getLogoutMessage() { return _successfulLogoutAlert.getText(); }

    public String getLoginFailedMessage()
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(_failedLoginAlert));

        return _failedLoginAlert.getText();
    }

}
