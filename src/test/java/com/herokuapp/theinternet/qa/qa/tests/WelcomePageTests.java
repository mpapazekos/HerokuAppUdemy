package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.FormAuthPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WelcomePageTests extends TestBase
{
    private WelcomePage _welcomePage;

    //-------------------------------------------------------------------------
    @BeforeMethod
    public void Setup() { _welcomePage = new WelcomePage(); }

    //-------------------------------------------------------------------------
    @Test
    public void user_should_be_able_to_visit_FormAuthPage()
    {
        FormAuthPage _formAuthPage = _welcomePage.goToFormAuthPage();

        String header = _formAuthPage.getMainHeader();

        Assert.assertEquals(header, "Login Page", "Wrong Page Fellas --> ");
    }
}
