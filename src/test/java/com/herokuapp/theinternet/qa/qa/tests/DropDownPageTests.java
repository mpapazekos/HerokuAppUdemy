package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.DropDownPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownPageTests extends TestBase
{
    private DropDownPage _dropdownPage;

    //-------------------------------------------------------------------------
    @BeforeMethod
    public void Setup()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _dropdownPage = _welcomePage.goToDropDownPage();
    }

    //-------------------------------------------------------------------------
    @Test
    public void user_should_be_able_to_select_any_option()
    {
        _dropdownPage.selectOptionByIndex(2);

        String _selectedOption = _dropdownPage.getSelectedOption();

        Assert.assertEquals(_selectedOption,"Option 2","Option 2 is not selected. Instead selected - " + _selectedOption);
    }

}
