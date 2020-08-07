package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.CheckboxesPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesPageTests extends TestBase
{
    private CheckboxesPage _checkBoxesPage;

    @BeforeMethod
    public void SetUp()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _checkBoxesPage = _welcomePage.goToCheckboxesPage();
    }

    @Test
    public void all_checkboxes_can_be_selected_simultaneously()
    {
        _checkBoxesPage.selectAllCheckboxes();

        boolean _result = _checkBoxesPage.areAllCheckboxesSelected();

        Assert.assertTrue(_result,"User should be able to select all checkboxes... ");
    }

}
