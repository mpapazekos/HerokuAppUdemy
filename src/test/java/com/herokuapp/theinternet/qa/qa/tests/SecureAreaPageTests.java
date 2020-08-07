package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.FormAuthPage;
import com.herokuapp.theinternet.qa.pages.SecureAreaPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecureAreaPageTests extends TestBase
{
    private SecureAreaPage _secureAreaPage;

    @BeforeMethod
    public void SetUp()
    {
        WelcomePage _welcomePage = new WelcomePage();
        FormAuthPage _formAuthPage = _welcomePage.goToFormAuthPage();
        _secureAreaPage = _formAuthPage.correctFormFillAndLogin();
    }

    @Test
    public void logout_button_should_successfully_logout_user()
    {
        FormAuthPage _formAuthPage = _secureAreaPage.pressLogoutButton();

        String _logoutAlertMsg = _formAuthPage.getLogoutMessage();

        Assert.assertEquals(_logoutAlertMsg,"You logged out of the secure area!\n×","Incorrect message... -->");
    }
}
