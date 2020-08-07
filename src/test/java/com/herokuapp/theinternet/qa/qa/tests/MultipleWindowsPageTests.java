package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.qa.pages.NewWindowPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsPageTests extends TestBase
{
    private MultipleWindowsPage _multipleWindowsPage;

    @BeforeMethod
    public void SetUp()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _multipleWindowsPage = _welcomePage.goToMultipleWindowsPage();
    }

    @Test
    public void user_should_be_able_to_switch_to_see_new_tab()
    {
        _multipleWindowsPage.clickOnNewWindowLink();

        NewWindowPage _newWindowPage = _multipleWindowsPage.switchToNewWindowPage();

        String _headerText = _newWindowPage.getMainHeaderText();
        Assert.assertEquals(_headerText,"New Window");
    }


}
