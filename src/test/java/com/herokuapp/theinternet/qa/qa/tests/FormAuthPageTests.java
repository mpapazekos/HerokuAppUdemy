package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.FormAuthPage;
import com.herokuapp.theinternet.qa.pages.SecureAreaPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;

import com.herokuapp.theinternet.qa.util.CsvDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class FormAuthPageTests extends TestBase
{
    private FormAuthPage _formAuthPage;

    //-------------------------------------------------------------------------
    @BeforeMethod
    public void Setup()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _formAuthPage = _welcomePage.goToFormAuthPage();
    }

    //-------------------------------------------------------------------------
    @Test
    public void login_button_should_exist()
    {
        String _currentText = _formAuthPage.getSubmitButtonText();

        Assert.assertEquals(_currentText,"Login","Wrong button fellas --> ");
    }

    @Test
    public void correct_login_should_navigate_to_secure_area()
    {
        SecureAreaPage secAreaPage = _formAuthPage.correctFormFillAndLogin();

        String alertMessage = secAreaPage.getLoginAlertMessage();

        Assert.assertEquals(alertMessage, "You logged into a secure area!\n×","Are you sure we are in the correct page? --> ");
    }

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void user_should_see_appropriate_message_when_login_fails(Map<String,String> _testData)
    {
        String username  = _testData.get("username");
        String password = _testData.get("password");
        String expectedErrorMessage = _testData.get("expectedMessage");

        _formAuthPage.customFormFillAndLogin(username,password);

        String alertMessage = _formAuthPage.getLoginFailedMessage();
        Assert.assertTrue(alertMessage.contains(expectedErrorMessage), "Message doesn't contain expected text.");
    }

}
